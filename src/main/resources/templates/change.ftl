<#import "parts/common.ftl" as c>

<@c.page>
    <div class="row" xmlns="http://www.w3.org/1999/html">

        <div class="col-sm">
            <div>
                <h1 class="text-center">Список доступных продуктов</h1>
            <HR>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Производитель</th>
                    <th scope="col">Модель</th>
                    <th scope="col">Изображение</th>
                    <th scope="col">Цена</th>
                    <th scope="col">Описание</th>
                    <th scope="col">Тип товара</th>
                    <th scope="col">Колличество</th>
                    <th scope="col">Действие</th>
                </tr>
                </thead>
                <#list products as product>
                    <tr>
                        <td> ${product.manufacturer}</td>
                        <td> ${product.model}</td>
                        <td>
                            <#if product.fileName??>
                                  <img src="/img/${product.fileName}" width="200" height="222" alt="">
                            </#if>
                        </td>
                        <td> ${product.price}</td>
                        <td> ${product.description}</td>
                        <td> ${product.productTypes}</td>
                        <td> ${product.amount}</td>
                        <td>
                            <div> <a href="/edit/${product.id}">Редактировать</a></div>
                            <div> <a href="/delete/${product.id}">Удалить</a></div>
                        </td>
                    </tr>
                </#list>
            </table>
            </div>

            <hr>

            <div>
            <h2>Добавить продукт</h2>
            <br/>
            <form action="/addProducts" method="post" enctype="multipart/form-data">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <table border="0" cellpadding="10">
                    <tr>
                        <td>Производитель:</td>
                        <td><input type="text" name="manufacturer"/></td>
                    </tr>
                    <tr>
                        <td>Модель:</td>
                        <td><input type="text" name="model"/></td>
                    </tr>
                    <tr>
                        <td>Цена товара:</td>
                        <td><input type="text" name="price"/></td>
                    </tr>
                    <tr>
                        <td>Изображение:</td>
                        <td><input type="file" name="file"/></td>
                    </tr>
                    <tr>
                        <td> Описание:</td>
                        <td><input type="text" name="description"/></td>
                    </tr>
                    <tr>
                        <td> Колличество:</td>
                        <td><input type="text" name="amount"/></td>
                    </tr>
                    <tr>
                        <td>Тип товара:</td>
                        <td><input type="text" name="productTypes"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><button type="submit">Сохранить</button></td>
                    </tr>
                </table>
            </form>
            </div>
        </div>
    </div>

</@c.page>