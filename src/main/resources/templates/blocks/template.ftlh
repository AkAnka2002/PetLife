<#macro template user>
    <!doctype html>
    <html lang="ru" xmlns="http://www.w3.org/1999/html">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
              crossorigin="anonymous">
        <link rel="stylesheet" href="/css/style.css" media="all">
        <title>PetLife</title>
        <style>
            .navbar {
                background-color: #ffc0cb;
            }
            body {
                background-color: #ffe4e1;
            }
        </style>
    </head>
<#--    py-3-->
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-dark">
                <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
                    <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor"
                         class="bi bi-balloon-heart-fill" viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
                              d="M8.49 10.92C19.412 3.382 11.28-2.387 8 .986 4.719-2.387-3.413 3.382 7.51 10.92l-.234.468a.25.25 0 1 0 .448.224l.04-.08c.009.17.024.315.051.45.068.344.208.622.448 1.102l.013.028c.212.422.182.85.05 1.246-.135.402-.366.751-.534 1.003a.25.25 0 0 0 .416.278l.004-.007c.166-.248.431-.646.588-1.115.16-.479.212-1.051-.076-1.629-.258-.515-.365-.732-.419-1.004a2.376 2.376 0 0 1-.037-.289l.008.017a.25.25 0 1 0 .448-.224l-.235-.468ZM6.726 1.269c-1.167-.61-2.8-.142-3.454 1.135-.237.463-.36 1.08-.202 1.85.055.27.467.197.527-.071.285-1.256 1.177-2.462 2.989-2.528.234-.008.348-.278.14-.386Z"/>
                    </svg>
                    <h3>PetLife</h3>
                </a>
                    <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                        <li><a href="/" class="nav-link px-2 link-dark nav_text">??????????????</a></li>
                        <#if user.email??>
                            <li><a href="/user/${user.id}" class="nav-link px-2 link-dark nav_text">??????????????</a></li>
                            <li><a href="/pet/${user.id?c}/mypet" class="nav-link px-2 link-dark nav_text">?????? ????????????????</a></li>
                            <li><a href="/calendar" class="nav-link px-2 link-dark nav_text">??????????????????</a></li>
                        </#if>
                    </ul>

                    <div class="text-end">
                        <#if user.email??>
                            <form action="/logout" method="post">
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                                <input type="submit" class="btn btn-light mr-2 nav_text" value="??????????"/>
                            </form>
                            <#if user.isAdmin()>
                                <a href="/admin" style="color: #fdfffc">???????????? ????????????????????????????</a>
                            </#if>
                        <#else>
                            <a href="/login" role="button" class="btn btn-outline-light mr-2 nav_text">??????????</a>
                            <a href="/registration" role="button" class="btn btn-light mr-2 nav_text">????????????????????????????????????</a>
                        </#if>
                    </div>
            </nav>
        </header>
    <div class="container mt-4 myclass w-100 m-auto text-center nav_text">
        <#nested/>
        <br>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.2.min.js"
            integrity="sha256-2krYZKh//PcchRtd+H+VyyQoZ/e3EcrkxhM8ycwASPA="
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
            integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
            crossorigin="anonymous"></script>
    </body>
    </html>
</#macro>