<table class="tbl">
    <tbody>
    <tr class="th">
        <td width="20">
            <label>
                <input type="checkbox" value="" id="J_checkbox">
            </label>
        </td>
        <td width="20">ID</td>
        <td>账号</td>
        <td>密码</td>
        <td width="100">操作</td>
    </tr>
    <#list userList as r>
    <tr>
        <td><input type="checkbox" name="id" data-userid="#"></td>
        <td>${r.id}</td>
        <td>${r.name}</td>
        <td>${r.passWord}</td>
        <td>
            <a href="update?id=${r.id}" data-id="${r.id}" class="button">修改</a>
        </td>
    </tr>
    </#list>
    </tbody>
</table>