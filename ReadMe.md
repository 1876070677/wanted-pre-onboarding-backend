# 버전 관리
1. Spring boot - 3.2.8
2. JDK 17 
3. MySQL - 8.0.37

# Api documentation

## 공고 관련 기능
|Http method| Url                                |Description| Request context                      | Response (Success)                                 |
|:--:|------------------------------------|:--:|--------------------------------------|----------------------------------------------------|
|POST| /recruiting/submit                 |공고 등록| Request body: SubRecruitingReq.class | {<br/>message="success", <br/>data=null<br/>}      |
|PUT| /recruiting/modify                 |공고 수정| Request body: ModRecruitingReq.class | {<br/>message="success",<br/> data=null<br/>}                     |
|Delete| /recruiting/delete?rec_id={공고 id}  |공고 삭제| Request param                        | {message="success", data=null<br/>}                     |
|GET| /recruiting/all|모든 공고 조회| None                                 | {<br/>message="success", <br/>data=List\<RecruitingListResp\><br/>} |
|GET|/recruiting/detail?rec_id={공고 id}|특정 공고 상세 보기| Request param| {<br/>message="success", <br/>data=RecrutingDetailResp<br/>}      |
|GET|/recruiting/list?search={keyword}|키워드로 공고 검색|Request param| {<br/>message="success", <br/>data=List\<RecruitingListResp\><br/>} |

## 사용자 관련 기능
|Http method| Url|Description| Request context                   | Response (Success) |
|:--:|--|:--:|-----------------------------------|--|
|POST|/user/submit|공고에 지원 하기| Request body: SubmittingReq.class |{<br/>message="success", <br/>data=null<br/>}|
