<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h3>Добавить нового питомца</h3>
    <form action="/pet/create" method="post" enctype="multipart/form-data">
        Кличка: <input type="text" name="name"/><br><br>
        Вид животного:
        <select class="form-select" aria-label="Select type" name="type">
            <option selected id="type"> </option>
            <option value="Кот">Кот</option>
            <option value="Собака">Собака</option>
            <option value="Кролик">Кролик</option>
            <option value="Попугай">Попугай</option>
            <option value="Енот">Енот</option>
            <option value="Морская свинка">Морская свинка</option>
            <option value="Хомяк">Хомяк</option>
            <option value="Лошадь">Лошадь</option>
            <option value="Корова">Корова</option>
            <option value="Другое">Другое</option>
        </select>
        Порода:<input type="text" name="breed"/><br><br>
        Пол:
        <select class="form-select" aria-label="Select gender" name="gender">
            <option selected id="gender"> </option>
            <option value="Мужской">Мужской</option>
            <option value="Женский">Женский</option>
            <option value="Другое">Другое</option>
        </select>
        Возраст: <input type="number" name="age"/> лет<br><br>
        Кастрация:
        <select class="form-select" aria-label="Select castration" name="castration">
            <option selected id="castration"> </option>
            <option value="Да">Да</option>
            <option value="Нет">Нет</option>
        </select>
        Описание: <input type="text" name="description"/><br><br>
        Фотография: <input type="file" name="file"/><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Добавить питомца"/>
    </form>
</@t.template>