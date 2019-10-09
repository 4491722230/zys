package store.zys.core.system.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import store.zys.common.base.Result;
import store.zys.common.constants.BaseEnums;
import store.zys.common.util.Results;
import store.zys.core.system.dto.User;
//import store.zys.core.system.service.UserService;
import store.zys.core.system.service.UserService;
import store.zys.core.system.service.impl.UserServiceImpl;


import javax.validation.Valid;
import java.util.List;

/**
 * @Author: zengyusheng
 * @Date: 2019/9/23 13:49
 * @Version 1.0
 */
@RestController
@RequestMapping
@Api(tags = "用户管理")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("查找所有用户")
    @GetMapping("/sys/user/queryAll")
    public Result queryAll() {
        List<User> list = userService.selectAll();
        return Results.successWithData(list, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }
    @ApiOperation("插入一个用户")
    @PostMapping("/sys/user/insert")
    public Result save(User user) {
        System.out.println("插入的属性"+user);
        User insert = userService.insert(user);
        return Results.successWithData(insert);
    }
    @ApiOperation("更新一个用户")
    @PutMapping("/sys/user/update")
    public Result update(User user) {
        System.out.println(11111);
        User update = userService.update(user);
        return Results.successWithData(user);
    }
    @ApiOperation("删除一个用户")
    @DeleteMapping("/sys/user/delete")
    public Result delete(long id) {
        int delete = userService.delete(id);
        return Results.successWithData(delete);
    }
    /*@RequestMapping("/sys/user/queryOne/{userId}")
    public Result queryOne(@PathVariable Long userId) {
        User user = userService.get(userId);
        return Results.successWithData(user);
    }

    @PostMapping("/sys/user/save")
    public Result save(@Valid @RequestBody User user) {
        user = userService.insertSelective(user);
        return Results.successWithData(user);
    }

    @PostMapping("/sys/user/update")
    public Result update(@Valid @RequestBody List<User> user) {
        user = userService.persistSelective(user);
        return Results.successWithData(user);
    }

    @RequestMapping("/sys/user/delete")
    public Result delete(User user) {
        userService.delete(user);
        return Results.success();
    }

    @RequestMapping("/sys/user/delete/{userId}")
    public Result delete(@PathVariable Long userId) {
        userService.delete(userId);
        return Results.success();
    }*/
}
