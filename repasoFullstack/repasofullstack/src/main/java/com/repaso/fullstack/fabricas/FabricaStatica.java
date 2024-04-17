package com.repaso.fullstack.fabricas;

import com.repaso.fullstack.accesodatos.DaoAlumno;
import com.repaso.fullstack.accesodatos.DaoAlumnoJpa;
import com.repaso.fullstack.accesodatos.DaoCurso;
import com.repaso.fullstack.accesodatos.DaoCursoJpa;

public class FabricaStatica implements Fabrica {

	@Override
	public DaoCurso getDaoCurso() {
		return new DaoCursoJpa();
	}

	@Override
	public DaoAlumno getDaoAlumno() {
		return new DaoAlumnoJpa();
	}

}
