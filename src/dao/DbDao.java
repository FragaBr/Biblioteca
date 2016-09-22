/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Bruna
 */
public interface DbDao<T> {
    
        public int inserir(T Obj) throws DaoException;
	public T pesquisar(String id) throws DaoException;
	public boolean excluir(int id) throws DaoException;
	public boolean alterar(T Obj) throws DaoException;    
}
