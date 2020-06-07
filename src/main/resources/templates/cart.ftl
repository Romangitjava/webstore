<#import "parts/common.ftl" as c>

<@c.page>
        <div>
            <#if orders??>
            <h2 class="mb-3 text-center">Корзина </h2>
        <table class="table">
            <thead>
                <tr class="m-2 b-2">
                    <th class="text-center" scope="col"><h4>Товар</h4></th>
                    <th class="text-center" scope="col"><h4>Цена</h4></th>
                    <th class="text-center" scope="col"><h4>Колличество</h4></th>
                    <th class="text-center" scope="col"><h4>Сумма</h4></th>
                </tr>
            </thead>
            <#list orders as order>
            <tbody>
                <tr>
                    <td>
                        <div class="media m-2 p-2">
                            <#if order.product.fileName??>
                                <img src="/img/${order.product.fileName}" width="150" height="165" alt="">
                            </#if>
                            <div class="media-body">
                                <p class="mt-4 p-3">${order.product.description} Здесь представлено описание продукта который находится в корзине</p>
                            </div>
                        </div>
                    </td>
                    <td class="p-5">
                        <h5 class="text-center p-2 m-1">${order.product.price}</h5>
                    </td>
                    <td class="p-5">
                        <div class="btn-group" role="group">
                            <button type="button" class="alert alert-light btn-danger" > - </button>
                            <H5 class="p-1 m-2">${order.quantity}</H5>
                            <button type="button" class="alert alert-light btn-success"> + </button>
                        </div>
                        <div class="row">
                            <div class="mx-auto">
                                <a href="/deleteOrder/${order.id}" class="active " role="button" aria-pressed="true">
                                    <svg class="bi bi-trash" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                        <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                                    </svg>
                                </a>
                            </div>
                        </div>
                    </td>
                    <td class="p-5">
                        <h5 class="text-center p-2 m-1">${order.orderPrice}</h5>
                    </td>
                </tr>
            </tbody>
            </#list>
        </table>

        <hr>

        <div class="container mt-5">
            <div class="row">
                <div class="mx-auto">
                    <a href="/deleteAllOrders" class="btn btn-danger btn-lg active" role="button" aria-pressed="true">Очистить корзину</a>
                </div>
                <div class="mx-auto">
                    <#if sumPrice??>
                        <h3>Общая сумма:  ${sumPrice} </h3>
                    </#if>
                </div>
                <div class="mx-auto">
                    <a href="#" class="btn btn-success btn-lg active" role="button" aria-pressed="true">Оформить заказ</a>
                </div>
            </div>
        </div>

        <#else >
            <h2 class="mb-3 text-center">Корзина пуста</h2>
        </#if>
        </div>

</@c.page>

