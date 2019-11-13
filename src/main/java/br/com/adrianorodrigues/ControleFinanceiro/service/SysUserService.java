package br.com.adrianorodrigues.ControleFinanceiro.service;

import br.com.adrianorodrigues.ControleFinanceiro.exceptions.ResourceNotFoundException;
import br.com.adrianorodrigues.ControleFinanceiro.model.SysUser;
import br.com.adrianorodrigues.ControleFinanceiro.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    public SysUser insertSysUser(SysUser sysUser) {
        return sysUserRepository.save(sysUser);
    }

    public SysUser updateSysUser(Long sysUserId, SysUser sysUserRequest) {
        return sysUserRepository.findById(sysUserId)
                .map(sysUser -> {
                    sysUserRequest.setId(sysUserId);
                    return sysUserRepository.save(sysUserRequest);
                }).orElseThrow(() -> new ResourceNotFoundException("SysUser not found with id " + sysUserId));
    }

    public ResponseEntity deleteSysUser(Long sysUserId) {
        sysUserRepository.findById(sysUserId)
                .map(product -> {
                    sysUserRepository.delete(product);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("SysUser not found with id " + sysUserId));
        return null;
    }

    public Page<SysUser> getSysUserList(Pageable pageable) {
        return sysUserRepository.findAll(pageable);
    }
}
