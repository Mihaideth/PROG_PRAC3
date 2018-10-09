package exception;

public class NoTrobat extends Exception {
		private static final long serialVersionUID=1L;  //Para que no aparezca warning
		public NoTrobat(){
			super("No s'ha trobat cap resultat");
		}
}
