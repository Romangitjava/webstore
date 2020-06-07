<#import "parts/common.ftl" as c>

<@c.page>

        <div class="row m-auto" type="/computers">
            <#list products as product>
                <div class="card m-2" style="width: 18rem;">
                    <#if product.fileName??>
                        <img src="/img/${product.fileName}" class="card-img-top" alt="...">
                    </#if>
                    <div class="card-body">
                        <h5 class="card-title ">${product.manufacturer} ${product.model}</h5>
                        <p class="card-text">${product.description}</p>
                    </div>
                    <div class="card-body">
                        <h5 class="card-link">${product.price} </h5>
                        <form class="form-group" action="addToOrder/${product.id}" method="post" >
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <button type="submit" class="btn btn-outline-success">Купить</button>
                        </form>
                    </div>
                </div>
            </#list>
        </div>

</@c.page>
