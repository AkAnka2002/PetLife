<#import "blocks/template.ftlh" as t>
<@t.template user>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
    <div class="calendar-wrapper">
        <button id="btnPrev" type="button">Предыдущий</button>
        <button id="btnNext" type="button">Следующий</button>
        <div id="divCal"></div>
    </div>
    <button id="notesForm" type="button">Показать события на эту дату</button>
    <h3>Добавить заметку</h3>
    <form id="noteForm" method="post" enctype="multipart/form-data">
        <p id="noteHeader"></p>
        Текст:<input type="text" name="text"/><br><br>
        <input type="hidden" name="id" value="${user.id}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Добавить заметку"/>
    </form>
    <script type="text/javascript">
        const userId = "${user.id}";
    </script>
    <script type="text/javascript" src="/webpack.config.js"></script>
</@t.template>