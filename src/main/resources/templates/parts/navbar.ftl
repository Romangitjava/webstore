<#include "security.ftl">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/main"> Главная страница <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/cart"> Корзина <span class="sr-only">(current)</span></a>
            </li>
           <#-- <#if isAdmin>-->
                <li class="nav-item active">
                    <a class="nav-link" href="/change"> База товаров <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/user"> Список пользователей <span class="sr-only">(current)</span></a>
                </li>
           <#-- </#if>-->
        </ul>

        <#if name != " ">
            <form class="form-group" action="/logout" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <span class="navbar-text-dark" > Пользователь: ${name}</span>
                <button type="submit" class="btn btn-outline-dark"> Выйти</button>
            </form>
        </#if>

    </div>
</nav>