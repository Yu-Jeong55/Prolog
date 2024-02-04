import { useState } from "react";
import styled from 'styled-components';

const TagsInput = styled.div`
display: flex;
align-items: center;
flex-wrap: wrap;
min-height: 40px;
width: 400px;
padding: 15px 10px;
background-color: rgb(245, 245, 245);
border-radius: 10px;

> ul {
  display: flex;
  flex-wrap: wrap;
  padding: 0 3px;
  margin: 0px;


  > .tag {
    width: auto;
    height: 28px;
    display: flex;
    align-items: center;
    justify-content: center;
    padding: 0 10px;
    font-size: 13px;
    list-style: none;
    margin: 0 8px 8px 0;
    color: rgb(245, 245, 245);
    background: rgb(54, 48, 98);
    border-radius: 13px;

    > .tag-close-icon {
      display: block;
      width: 13px;
      height: 14px;
      line-height: 13px;
      text-align: center;
      font-size: 10px;
      margin-left: 5px;
      border-radius: 45%;
      color: rgb(54, 48, 98);
      background: rgb(245, 245, 245);
      cursor: pointer;
    }
  }
}

> input {
  flex: 1;
  border: none;
  font-size: 13px;
  background-color: rgb(245, 245, 245);
  padding: 5px 5px;
}

.tag-input:focus {
    outline: none;
}
`

function Tag({color}) {
    const initialTags = ['삼성', '가자']
    const [tags, setTags] = useState(initialTags)

    // 태그 삭제
    function removeTags(indexToRemove) {
        const filter = tags.filter((element, index) => index !== indexToRemove)
        setTags(filter)
    }

    // 태그 추가
    function addTags(event) {
        const inputValue = event.target.value
        console.log(event)
        // 아무것도 입력하지 않았으면 추가 X => ??????????
        if (event.key === "Enter" && inputValue !== '') {
            setTags([...tags, inputValue])
            event.target.value = ''
        }
    }

    return (
        <>
            <TagsInput>
                <ul id="tags">
                    {tags.map((tag, index) => (
                        <li key={index} className="tag">
                            <span className="tag-content">{tag}</span>
                            <span className="tag-close-icon" onClick={() => removeTags(index)}>X</span>
                        </li>
                    ))}
                </ul>
                <input
                    type="text"
                    className="tag-input"
                    onKeyUp={(e) => addTags(e)}
                    placeholder="Press enter to add tags" />
            </TagsInput>
        </>
    )
}

export default Tag