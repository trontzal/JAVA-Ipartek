package com.repaso.fullstack.configuraciones;

import com.repaso.fullstack.accesodatos.DaoAlumno;
import com.repaso.fullstack.accesodatos.DaoCurso;
import com.repaso.fullstack.fabricas.Fabrica;
import com.repaso.fullstack.fabricas.FabricaStatica;

public class Globales {
	private static final Fabrica fabrica = new FabricaStatica();
	
	public static final DaoCurso daoCurso = fabrica.getDaoCurso();
	public static final DaoAlumno daoAlumno = fabrica.getDaoAlumno();

}
