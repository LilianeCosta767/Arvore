package arvore;

public class TArvore {
	public TNodo T;
	public TArvore () {
		T = null ;
	}
	
	public TNodo raiz (){
		return T;
	}
	
	public void insere ( TInfo item ) {
		T = insere (T,item , null );
	}
	
	public TNodo insere ( TNodo T, TInfo item , TNodo pai) {
		if (T == null ) {
			T = new TNodo (item , pai );
		} else {
			pai = T;
			if ( item . chave < T. item . chave )
			T. esq = insere (T.esq ,item , pai );
			else if ( item . chave > T. item . chave )
			T. dir = insere (T.dir ,item , pai );
		}
		return T;
	}
	
	public void inserirSEQ ( int [] dados , int i, int j) {
		TInfo item = new TInfo ( dados [0] ,""); insere ( item );
		for (int p =1;p <5; p++) {
			item . chave = dados [p]; insere ( item );
		}
	}
	
	public void inserirBIN ( int [] dados , int i, int j) {
	/* O EXERCI CIO SE RESUME A COMPLETAR ESTE ME TODO !!! */
		for(int c=j; c >= i; c--) {
			int x = c/2;
			TInfo item = new TInfo(dados[x], "");
			insere(item);
		}for(int c=i; c <= j; c++) {
			int y = (c+j)/2;
			TInfo item2 = new TInfo(dados[y], "");
			insere(item2);
			
		}
	}
	
	public TNodo pesquisa ( TInfo item ) {
		return pesquisa (T, item );
	}
	
	public TNodo pesquisa ( TNodo T, TInfo item ) {
		if (T == null ) {
			return T;
		} else {
			if ( item . chave == T. item . chave )
				return T;
			else if ( item . chave < T. item . chave )
				T = pesquisa (T.esq , item );
			else
				T = pesquisa (T.dir , item );
		}
		return T;
	}
	
	public TNodo Remove ( TNodo T, TInfo X) {
		if (T == null ) return T;
		if (X. chave == T. item . chave ){
			TNodo P = T;
			if ((T. esq == null ) && (T. dir == null ))
			if (T. item . chave > T.pai. item . chave )
				T. pai . dir = null ;
			else
				T. pai . esq = null ;
			else
			if (T. esq == null ) {
					if (T. pai != null ) {
					if (T. dir != null ) T. dir .pai = T. pai ;
					if (T. item . chave > T.pai. item . chave )
					T. pai . dir = T. dir;
					else
					T. pai . esq = T. dir;
				} else {
					this .T = T. dir ;
					this .T. pai = null ;
				}
			}
			else
				if (T. dir == null ) {
					if (T. pai != null ) {
						if (T. esq != null ) T. esq .pai = T. pai ;
						if (T. item . chave > T.pai. item . chave )
						T. pai . dir = T. esq;
						else
						T. pai . esq = T. esq;
					} else {
						this .T = T. esq ;
						this .T. pai = null ;
					}
				}
			else
			{
				P = getMax (T. esq );
				T. item = P. item ;
			}
		}
		else
			if (X. chave < T. item . chave )
				Remove (T.esq ,X);
			else
				Remove (T.dir ,X);
		return T;
	}
	
	public TNodo getMax ( TNodo T) {
		if (T. dir == null )
		{
			if (T. esq != null ) T. esq .pai = T. pai ;
			if (T. item . chave > T.pai. item . chave )
				T. pai . dir = T. esq;
			else
				T. pai . esq = T. esq;
			return T;
		}
		else
			return getMax (T.dir);
	}
	
	public void emOrdem ( TNodo T) {
		if (T != null ) {
			emOrdem (T. esq );
			System . out . print (T. item + " ");
			emOrdem (T. dir );
		}
	}
	
	public void preOrdem ( TNodo T) {
		if (T != null ) {
			System . out . print (T. item + " ");
			preOrdem (T. esq );
			preOrdem (T. dir );
		}
	}
	
	public void posOrdem ( TNodo T) {
		if (T != null ) {
			posOrdem (T. esq );
			posOrdem (T. dir );
			System . out . print (T. item + " ");
		}
	}
	
	public void mostraArvore (){
		TPilhaPonteiro globalStack = new TPilhaPonteiro();
		globalStack . push ( this .T);
		int nBlanks = 32;
		boolean isRowEmpty = false ;
		System . out . println (" ................................................................... ");
		while ( isRowEmpty == false )
		{
			TPilhaPonteiro localStack = new TPilhaPonteiro();
			isRowEmpty = true ;
			for ( int j =0; j< nBlanks ; j ++)
				System . out . print (" ");
			while ( globalStack . vazia () == false )
			{
				TNodo temp = ( TNodo ) globalStack . pop ();
				if( temp != null )
				{
					System . out . print ( temp . item );
					localStack . push ( temp . esq );
					localStack . push ( temp . dir );
					if( temp . esq != null || temp . dir != null )
					isRowEmpty = false ;
				}
				else
				{
					System . out . print (" --");
					localStack . push ( null );
					localStack . push ( null );
				}
				for ( int j =0; j< nBlanks *2 -2; j ++)
					System . out . print (" ");
			}
			System . out . println ();
			nBlanks /= 2;
			while ( localStack . vazia () == false )
				globalStack . push ( localStack . pop () );
		}
		System . out . println (" ................................................................... ");
	}
}