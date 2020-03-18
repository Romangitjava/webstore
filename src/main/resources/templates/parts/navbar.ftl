<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/main"> Главная страница <span class="sr-only">(current)</span></a>
            </li>
        </ul>

        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/cart"> Корзина <span class="sr-only">(current)</span></a>
            </li>
        </ul>

        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/change"> База товаров <span class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>


    <form class="form-group" action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-outline-dark"> Выйти </button>
    </form>

</nav>