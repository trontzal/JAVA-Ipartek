package com.repaso.fullstack.fabricas;

import com.repaso.fullstack.accesodatos.DaoCurso;
import com.repaso.fullstack.accesodatos.DaoCursoJpa;

public class FabricaStatica implements Fabrica {

	@Override
	public DaoCurso getDaoCurso() {
		return new DaoCursoJpa();
	}

}
