package br.com.contatos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/*
 * É herdado da interface JpaRepository para ter acesso a métodos como save(), delete(), findAll()
 * Necessário criar uma interface pois o JPARepository também é uma interface, sendo assim, é possível herdar
 * É necessário herdar do JPARepository para ter acesso as variedades de métodos, devido a isso é criada essa interface
 */
@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
    //Like é utilizado quando busco um tipo específico na coluna, por exemplo, procurar um nome específico com uma inicial, é colocado entre porcentagens
    @Query(value = "select c from Contato c where c.nomeDoContato like %?1%")
    List<Contato> buscaPorNome(String nome);

}
