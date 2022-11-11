package br.com.contatos;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Declarando a classe como controlador através da Annotation @RestController
 *
 */
@RestController
public class ContatoController {

    /**
     * Criação do objeto repository do tipo ContatoRepository, criado o objeto para que possa ter acesso aos métodos do Spring JPA
     * Injeção de dependência: é uma técnica que delega ao framework a responsabilidade de injetar as dependencias utilizadas em um determinado componente declarado
     * Annotation utilizada para marcar o ponto de injeção de dependência na classe
     *
     */
    @Autowired
    private ContatoRepository contatoRepository;

    /**
     * Criação do método listarContatos
     * RequestMapping define uma rota No método abaixo, ao definir a rota /contatos, será utilizado
     * O método GET para listar todos os clientes já cadastrados
     *
     * @return
     */
    @RequestMapping(value = "/contatos/listatodos", method = RequestMethod.GET)
    public List<Contato> listarContatos() {
        return contatoRepository.findAll();
    }

    /**
     * Método criado para exibir contato por id
     * Utilizado o ResponseEntity para controlar resposta de Status, cabeçalhos e body do retorno
     * O @PathVariable é utilizado quando o atributo/variável é passado diretamente na URL, ou seja, neste caso o atributo id está sendo passado diretamente na URL
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/contatos/listaporid/{id}", method = RequestMethod.GET)
    public ResponseEntity<Contato> exibeContatoPorId(@PathVariable(value = "id") long id) {
        //Utilizado para definir a rota por Id
        Optional<Contato> contato = contatoRepository.findById(id);
        return new ResponseEntity<>(contato.get(), HttpStatus.OK);
    }

    /**
     * Criação do método cadastrarContato do tipo Contato, no método abaixo é definida a rota através do RequestMapping e chamado o method Post
     * A Annotation @RequestBody indica ao framework que os dados não serão enviados/recebidos por meio de página web
     *
     * @param contato
     * @return
     */
    @RequestMapping(value = "/contatos/cadastrar", method = RequestMethod.POST)
    public Contato cadastrarContato(@RequestBody Contato contato) {
        return contatoRepository.save(contato);
    }

    /**
     * Utilizada a Annotation RequestMapping para definir a rota
     * Após isso, criado o método deletaClientePorId e nele há a Annotation PathVariable, responsável por incluir um parâmetro na URL
     * ResponseEntity é a resposta da entidade, ela é responsável pelo controle de respostas
     * Optional é o substituto de NullPointerExcpetion, ele da acesso ao componente isPresent, no qual valida se possui Id
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/contatos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Contato> deletaClientePorId(@PathVariable(value = "id") long id) {

        Optional<Contato> contato = contatoRepository.findById(id);
        if (contato.isPresent()) {
            contatoRepository.delete(contato.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "buscarPorNome")
    @ResponseBody
    public ResponseEntity<List<Contato>> buscarPorNome(@RequestParam(name = "nomeDoContato") String name) {

        List<Contato> contato = contatoRepository.buscaPorNome(name);

        return new ResponseEntity<List<Contato>>(contato, HttpStatus.OK);
    }

}
