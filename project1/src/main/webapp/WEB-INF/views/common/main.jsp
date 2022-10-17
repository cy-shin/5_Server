<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>1수업용 프로젝트</title>

    <link rel="stylesheet" href="/project1/resources/css/main-style.css">

    <script src="https://kit.fontawesome.com/f7459b8054.js" crossorigin="anonymous"></script>
</head>
<body>
    <main>
        <header>
            <section>
                <!-- 클릭 시 메인페이지로 이동하는 로고 -->
                <a href="#">
                    <img id="home-logo" src="/project1/resources/images/logo.jpg" alt="로고">
                </a>

                
            </section>
            <!-- 검색창 영역 -->
            <section>
                <article class="search-area">
                    <!-- form 태그 : 내부 input태그의 값을 서버 또는 페이지로 전달(= 제출) -->
                    <form action="#">
                        <fieldset>
                            <input type="text" id="query" name="query" 
                             placeholder="검색어를 입력해주세요.">
            
                            <button type="submit" id="search-btn" class="fa-solid fa-magnifying-glass">
                                <!-- i태그에서 class만 꺼내서 버튼에 class로 추가함 -->
                                <!-- 글자처럼 취급되어서 font관련 스타일로 꾸밀 수 있음 -->
                            </button>
                        </fieldset>
                    </form>
                </article>
            </section>


            <section></section>
        </header>
        
        <nav>
            <ul>
                <%-- <li><a href="#">공지사항</a> </li>
                <li><a href="#">자유 게시판</a></li>
                <li><a href="#">질문 게시판</a></li>
                <li><a href="#">FAQ</a></li>
                <li><a href="#">1:1문의</a></li> --%>

                <c:forEach var="boardType" items="${boardTypeMap}">
                    <%-- 
                        EL을 이용해서 Map 데이터를 다루는 방법 
                      -  key ==> ${변수명.key}
                      -  value ==> ${변수명.value}
                    --%>
                    <li><a href="/board/${boardType.key}/list">${boardType.value}</a></li>
                </c:forEach>
            </ul>
        </nav>

        <section class="content">
            <section class="content-1"></section>

            <section class="content-2">
                <form action="#" name="login-frm">
                    <!-- frm form -->
                    <!-- 아이디, 비밀번호, 로그인 버튼 -->
                    <fieldset id="id-pw-area"> 
                        <!-- 아이디/비밀번호 -->
                        <section>
                            <input type="text" name="inputId" placeholder="아이디" autocomplete="off">
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

    <footer>
        <p>
            Copyright &copy; Kh Information Educational Institute A-Class
        </p>
        <!-- 단락, 글자만 넣은 후 영역을 나누고 싶을 때 활용 -->
        <!-- &copy : copyright -->

        <article>
            <a href="#">프로젝트 소개</a>
            <span>|</span>
            <a href="#">이용약관</a>
            <span>|</span>
            <a href="#">개인정보 처리방침</a>
            <span>|</span>
            <a href="#">고객센터</a>
        </article>
    </footer>

</body>
</html>