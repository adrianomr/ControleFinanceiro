package br.com.adrianorodrigues.ControleFinanceiro.controller;

import br.com.adrianorodrigues.ControleFinanceiro.model.SysUser;
import br.com.adrianorodrigues.ControleFinanceiro.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("sys-user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping
    public Page<SysUser> getSysUsers(Pageable pageable) {
        return sysUserService.getSysUserList(pageable);
    }


    @PostMapping
    public SysUser createSysUser(@Valid @RequestBody SysUser sysUser) {
        return sysUserService.insertSysUser(sysUser);
    }

    @PutMapping("/{sysUserId}")
    public SysUser updateSysUser(@PathVariable Long sysUserId,
                                 @Valid @RequestBody SysUser sysUserRequest) {
        return sysUserService.updateSysUser(sysUserId, sysUserRequest);
    }


    @DeleteMapping("/{sysUserId}")
    public ResponseEntity<?> deleteSysUser(@PathVariable Long sysUserId) {
        return sysUserService.deleteSysUser(sysUserId);
    }
}
