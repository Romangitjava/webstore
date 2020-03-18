<#import "parts/common.ftl" as c>

<@c.page>


    <div class="row">
        <#list orders as orders>
            <div class="col-7">
                <div class="media">
                    <img width="180" height="180" src="/img/${orders.product.fileName}" class="align-self-center mr-3" alt="...">
                    <div class="media-body">
                        <H6 class="mt-5"> ${orders.product.description}</H6>
                        <form class="form-group" action="/deleteOrder/${orders.id}" method="post" >
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <button type="submit" class="btn btn-outline-success">Удалить</button>
                        </form>
                    </div>
                    <hr>
                </div>
            </div>

            <div class="col-2">
                <div class="media-body">
                    <h6 class="mt-4">Цена:</h6>
                    <p>${orders.product.price}</p>

                    <h6>Колличество:</h6>
                    <p>${orders.quantity}</p>
                </div>
            </div>

        </#list>

    </div>

</@c.page>