package generationBrasil.Nexo.Security;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import generationBrasil.Nexo.Model.Usuario;
import generationBrasil.Nexo.Repository.UsuarioRepository;



/**
 * Classe utilizada para validação do usuário no banco de dados.
 * 
 * @since 1.0
 * @author Felipe Gustavo.
 */

@Service
public class UserDetailsServiceImplements implements UserDetailsService {
	
	private @Autowired UsuarioRepository repositorio;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repositorio.findByEmail(username);
		
		if (usuario.isPresent()) {
			return new UserDetailsImplements(usuario.get());
		} else {
			throw new UsernameNotFoundException(username + " não encontrado.");
		}
	}

}