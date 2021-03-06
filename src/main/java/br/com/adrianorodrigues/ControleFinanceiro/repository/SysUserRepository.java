package br.com.adrianorodrigues.ControleFinanceiro.repository;

import br.com.adrianorodrigues.ControleFinanceiro.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

}