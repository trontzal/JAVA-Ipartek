package com.repaso.fullstack.fabricas;

import com.repaso.fullstack.accesodatos.DaoAlumno;
import com.repaso.fullstack.accesodatos.DaoCurso;

public interface Fabrica {
	DaoCurso getDaoCurso();

	DaoAlumno getDaoAlumno();
}
