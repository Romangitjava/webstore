<#import "parts/common.ftl" as c/>
<@c.page>
    <#if massage??>
        ${massage}
    </#if>
    <form  action="/registration" method="post" >
        Введите данные для регистрации
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
            <input type="submit" class="btn btn-outline-dark" value="Зарегистрироваться"/>
        </div>
    </form>

</@c.page>