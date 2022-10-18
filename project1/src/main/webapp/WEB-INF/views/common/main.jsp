<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>1수업용 프로젝트</title>

    <link rel="stylesheet" href="/resources/css/main-style.css">

    <script src="https://kit.fontawesome.com/f7459b8054.js" crossorigin="anonymous"></script>
</head>
<body>
    <main>
       <%-- header.jsp 추가{포함} --%>
		<%--
			jsp 액션 태그 중 include?
			- 해당 위치에 page 속성으로 지정된 jsp 파일의 내용이 포함됨
			- jsp파일의 경로는 /webapp 폴더를 기준으로 작성
		 --%>
        <%-- WEBAPP폴더를 기준으로 경로 작성하기 --%>
       <jsp:include page="/WEB-INF/views/common/header.jsp" />

        <section class="content">
            <section class="content-1">
                ${loginMember}
            </section>

            <section class="content-2">
                       <%-- 절대 경로 방식 (현재 /가 프로젝트 최상위) --%>
                <form action="/member/login" name="login-frm" method="POST">
                    <!-- frm form -->
                    <!-- 아이디, 비밀번호, 로그인 버튼 -->
                    <fieldset id="id-pw-area"> 
                        <!-- 아이디/비밀번호 -->
                        <section>
                            <input type="text" name="inputEmail" placeholder="이메일" autocomplete="off">
                            <input type="password" name="inputPw" placeholder="비밀번호">
                        </section>
        
                        <!-- 로그인 -->
                        <section>
                            <!-- 버튼 태그에 type 안쓰면 기본값 submit -->
                            <button>로그인</button>
                        </section>
                    </fieldset>
        
                    <!-- 아이디 저장 체크박스 -->
                    <!-- label 태그 내부에 input 태그를 작성하면 label for="id"를 작성한 것처럼 만들어짐 -->
                    <label>
                        <input type="checkbox" name="saveId"> 아이디 저장
                    </label>
        
                    <!-- 회원가입, ID/PW찾기 -->
                    <article id="signUp-find-area">
                        <a href="#">회원가입</a>
                        <span>|</span>
                        <a href="#">ID/PW찾기</a>
                    </article>
                </form>


            </section>
        </section>
    </main>

    <%-- footer.jsp 포함 --%>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>