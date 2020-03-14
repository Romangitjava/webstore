<#import "parts/common.ftl" as c>

<@c.page>

    <div class="row" type="/appliances" >
        <#list products as product>
            <div class="card" style="width: 18rem;">

                <#if product.fileName??>
                    <img src="/img/${product.fileName}" class="card-img-top" alt="...">
                </#if>
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                </div>

                <ul class="list-group list-group-flush">
                    <li class="list-group-item">${product.manufacturer}</li>
                    <li class="list-group-item">${product.model}</li>
                    <li class="list-group-item">${product.price}</li>
                </ul>

                <div class="card-body">
                    <a href="#" class="card-link">Card link</a>
                    <a href="#" class="card-link">Another link</a>
                </div>

            </div>
        </#list>

    </div>

</@c.page>