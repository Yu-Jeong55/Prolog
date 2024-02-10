package com.b112.prolog.user.service;

import com.b112.prolog.user.exception.OAuth2AuthenticationPrepareException;
import com.b112.prolog.user.info.OAuth2UserInfo;
import com.b112.prolog.user.info.OAuth2UserInfoFactory;
import com.b112.prolog.user.info.OAuth2UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        try {
            return prepareOAuth2User(userRequest, oAuth2User);
        } catch (AuthenticationException exception) {
            throw exception;
        } catch (Exception exception) {
            throw new InternalAuthenticationServiceException(exception.getMessage(), exception.getCause());
        }
    }

    private OAuth2User prepareOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {
        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        String accessToken = userRequest.getAccessToken().getTokenValue();

        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(registrationId, accessToken, oAuth2User.getAttributes());

        if (!StringUtils.hasText(oAuth2UserInfo.getEmail())) {
            throw new OAuth2AuthenticationPrepareException("OAuth2 provider로부터 이메일을 받지 못했습니다.");
        }
//        if (!StringUtils.hasText(oAuth2UserInfo.getNickName())) {
//            throw new OAuth2AuthenticationPrepareException("OAuth2 provider로부터 닉네임을 받지 못했습니다.");
//        }

        return new OAuth2UserPrincipal(oAuth2UserInfo);
    }

}
