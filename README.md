# 스킬파이트 리뉴얼
예전에 작성한 [이 미니게임 플러그인](https://github.com/NamuTree0345/ij-got-minigame) 을 리라이트했습니다.
## 명령어
* O: 오피전용
* D: 디버그 전용
###
1. O `/map <구조물 이름(예: village, pillager_outpost)` : 시작할 구조물 선택
2. O `/start` : 시작 명령어
3. `/cc select` : 스킬 선택창
4. O D `/cc wand <name> <material>` : 스킬 완드 얻기(디버그 전용이니 사용하지 않으셔도 됨.)
## 리라이트 내역
### 인게임
- 마법사, 폭탄병 추가
- 검수 스킬 추가
- 여러 스킬들 연출 업데이트
- 직업 선택 창 업그레이드
- 여러 기능 캡슐화랄까
### 기술
- 언어 자바 -> 코틀린
- 페이퍼 1.16.4 -> 1.16.5
- Kommand 사용
## 빌드
`./gradlew build` 시 `build/libs/SkillFightRenewal-1.0.0.jar`로 나옵니다.
## 라이센스
```
MIT License

Copyright (c) 2021 나무트리

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```