<#import "parts/common.ftl" as c>

<@c.page>


    <div class="row">

        <div class="col-8">
            <#list orders as orders>
                <div class="card border-success mt-2 p-2" style="max-width: 800px;">
                    <div class="media">
                        <#if orders.product.fileName??>
                            <img width="180" height="180" src="/img/${orders.product.fileName}"
                                 class="align-self-center mr-3" alt="...">
                        </#if>
                        <div class="media-body">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">${orders.product.description}</li>
                                <li class="list-group-item">Цена: ${orders.orderPrice}</li>
                                <li class="list-group-item">Количество: ${orders.quantity}</li>
                            </ul>
                        </div>
                    </div>
                    <form class="form-group" action="/deleteOrder/${orders.id}" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-outline-success">Удалить</button>
                    </form>
                </div>
            </#list>
        </div>

        <div class="col-4">
            <div class="card border-success mt-2 p-2" style="height: 400px">
                <#assign num = num>
                <h5>Сумма к оплате:</h5>
                <h5>${num}</h5>
            </div>
        </div>

    </div>


</@c.page>