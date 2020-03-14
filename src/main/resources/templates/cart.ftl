<#import "parts/common.ftl" as c>

<@c.page>


    <div class="row">
    <#list cart as cart>
        <div class="col-8">

                <ul class="list-unstyled">
                    <li class="media">
                        <img src="" class="mr-3" alt="...">
                        <div class="media-body">
                            <h5 class="mt-0 mb-1">List-based media object</h5>

                        </div>
                    </li>
                </ul>

        </div>

        <div class="col-4">
            Колличество :  ${cart.quantity}

        </div>
    </#list>
    </div>

</@c.page>