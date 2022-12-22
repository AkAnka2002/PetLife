<#import "blocks/template.ftlh" as t>
<@t.template user>

<body class="text-center">
<main class="form-signin w-100 m-auto">
    <div class="col-lg-6 col-md-8 mx-auto">
    <form action="/login" method="post">
        <h1 class="h3 mb-3 fw-normal">Авторизация</h1>
        <div class="form-floating">
            <input type="email" name="username" class="form-control" id="floatingInput" placeholder="name@example.com" required>
            <label for="floatingInput">Адрес электронной почты</label>
        </div>
<br>
        <div class="form-floating">
            <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password" required>
            <label for="floatingPassword">Пароль</label>
        </div> <br>

        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" class="btn btn-light me-2 btn-my nav_text" value="Войти"/>
    </form> <br>
    <a href="/registration">Зарегистрироваться</a>
    </div>
</main>
</body>
</@t.template>