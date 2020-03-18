<#import "parts/common.ftl" as c>

<@c.page>
    <div class="row">

        <div class="col">
            <form class="form-inline mb-4" action="/search" method="get">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <input class="form-control mr-sm-2" type="search" placeholder="Поиск" name="keyword" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Найти</button>
            </form>
            <div class="list-group" style="width: 380px">
                <a href="/computers" class="list-group-item mt-3 list-group-item-action list-group-item-success">Компьютеры</a>
                <a href="/phones" class="list-group-item mt-3 list-group-item-action list-group-item-success">Смартфоны</a>
                <a href="/TV" class="list-group-item mt-3 list-group-item-action list-group-item-success">Телевизоры</a>
                <a href="/appliances" class="list-group-item mt-3 list-group-item-action list-group-item-success">Бытовая техника</a>
                <a href="/accessories" class="list-group-item mt-3 list-group-item-action list-group-item-success">Аксессуары</a>
            </div>

        </div>

        <div class="col">
              <#list products as product>
            <div class="card border-success mb-3" style="max-width: 600px;">
                <div class="row no-gutters">
                    <div class="col-md-6">
                        <img src="/img/${product.fileName}" alt="...">
                    </div>
                    <div class="col-md-6">
                        <div class="card-body">
                            <h5 class="card-title">${product.manufacturer} ${product.model} </h5>
                            <hr>
                            <p class="card-text">${product.description}</p>
                            <p class="card-text"> Цена: ${product.price} P</p>
                        </div>
                </div>
            </div>
        </div>
              </#list>
    </div>
</@c.page>

