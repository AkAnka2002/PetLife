<#import "blocks/template.ftlh" as t>
<@t.template user>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
    <div class="calendar-wrapper">
        <button id="btnPrev" type="button">Предыдущий</button>
        <button id="btnNext" type="button">Следующий</button>
        <div id="divCal"></div>
    </div>
</@t.template>