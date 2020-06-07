<#import "parts/common.ftl" as c>

<@c.page>
    <form  action="/login" method="post" >
        <h2>Введите имя пользователя</h2>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div class="form-group">
            <label for="formGroupExampleInput">Имя пользователя:</label>
            <input type="text" name="username" class="form-control" id="formGroupExampleInput" placeholder="name">
        </div>
        <div class="form-group">
            <label for="formGroupExampleInput">Пароль:</label>
            <input type="password" name="password" class="form-control" id="formGroupExampleInput" placeholder="password">
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-outline-dark" value="Войти"/>
        </div>
        <div class="form-group">
           <a href="/registration"> Авторизация </a>
        </div>
    </form>

</@c.page>

