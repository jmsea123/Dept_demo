package com.hyz.dept.controller;

import com.hyz.dept.common.R;
import com.hyz.dept.entity.Dept;
import com.hyz.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /** 查询所有部门 GET /dept/list */
    @GetMapping("/list")
    public R<List<Dept>> list(){
        List<Dept> depts = deptService.getAll();
        return R.success(depts);
    }

    /** 按编号查询 GET /dept/10 */
    @GetMapping("/{deptno}")
    public R<Dept> get(@PathVariable("deptno") Integer deptno){
        Dept dept = deptService.getById(deptno);
        if(dept == null){
            // 数据不存在，返回业务404
            return R.notFound("该部门编号不存在");
        }
        return R.success(dept);
    }

    /** 新增 POST /dept  参数放请求体 JSON：{"dname":"研发部","loc":"北京"} */
    @PostMapping
    public R<Dept> insert(@RequestBody Dept dept) {
        // service执行新增，内部会给dept设置deptno主键
        deptService.addDept(dept);
        // 此时dept对象里面已经有 newDeptno 了
        return R.success(dept,"新增成功");
    }

    /** 修改 PUT /dept  JSON：{"deptno":10,"dname":"研发部","loc":"上海"} */
    @PutMapping
    public R<Dept> update(@RequestBody Dept dept) {
        int rows = deptService.updateDept(dept);
        if (rows > 0) {
            return R.success(dept,"修改成功");
        } else {
            return R.notFound("修改失败，该部门不存在");
        }
    }

    /** 删除 DELETE /dept/10 */
    @DeleteMapping("/{deptno}")
    public R<Void> delete(@PathVariable Integer deptno) {
        int rows = deptService.deleteDept(deptno);
        if (rows > 0) {
            return R.success(null,"删除成功");
        } else {
            return R.notFound("删除失败，该部门不存在");
        }
    }
}
