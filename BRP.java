package basic;
import basic.Reader;
import java.util.*;
import java.lang.reflect.*;
public class BRP{
	public static void print(Object... args){
		for(Object arg:args){println(arg);}
		System.out.println();}

	public static void println(Object... a){
		for(Object i:a){
			System.out.print(i);
			System.out.print(" ");}
		}
	public static void printa(Object[]... arrays){
		for(Object[] array:arrays){
		for(Object e:array){println(str(e));};print();}
	}
	public static void printa(List<?> a){print(str(a));}

	public static int[] range(int f){
		int[] list = new int[f];
		for(int i = 0;i<f;i++){
			list[i] = i;
		}return list;}

	public static int[] range(int f,int l){
		final int n = l-f;
		int[] list = new int[n];
		int p = 0;
		for(int i = f;i<l;i++){
			list[p++] = i;
		}return list;}

	public static int[] range(int f,int l,int m){
		final int ln = (l-f);
		int n = (ln/m);//Size of array
		if(ln%m != 0){n+=1;}
		int[] list = new int[n];
		int p = 0;//Position of array
		for(int i = f;i<l;i+=m){
			list[p++] = i;
		}return list;}

	public static Integer[] into(int[] array){
		Integer[] newArray = new Integer[array.length];
		int i = 0;
		for (int value : array) {
			newArray[i++] = Integer.valueOf(value);
		}return newArray;}
	public static Character[] chato(char[] array){
		Character[] newArray = new Character[array.length];
		int i = 0;
		for (char value : array) {
			newArray[i++] = Character.valueOf(value);
		}return newArray;}

	public static Float[] flato(float[] array){
		Float[] newArray = new Float[array.length];
		int i = 0;
		for (float value : array) {
			newArray[i++] = Float.valueOf(value);
		}return newArray;}

	public static boolean in(Object[] array,Object e){
        return (Arrays.binarySearch(array,e)>0);}

	public static boolean notin(Object[] array,Object e){return !(in(array,e));}
	
	public static int count(Object[] array, Object e){
		return Arrays.binarySearch(array, e);}

	public static String[] splitlines(String txt){return txt.split("\n");}
	
	public static int[] slice(int[] a,int s,int e){
		return Arrays.copyOfRange(a,s,e);}

	public static List<?> slice(List<?> a,int s,int e){
					return a.subList(s,e+1);}

	public static String str(Object obj){return obj.toString();}
	
	public static String[] str(Object[] obj){
		String[] array = new String[obj.length];
		int x = 0;
		for(Object i:obj){
			array[x++] = str(i);
		}return array;}

	public static float flot(Object obj){return Float.parseFloat(str(obj));}
	public static int Int(String obj){return Integer.parseInt(obj);}
	public static int Int(Character obj){return Integer.parseInt(str(obj));}
	public static int Int(Double obj){return obj.intValue();}
	public static int Int(Long obj){return obj.intValue();}
	public static int Int(Float obj){return obj.intValue();}
	public static int Int(Object obj){return Int(str(obj));}
	public static int[] Int(Object[] a){
		List<Integer> list = new ArrayList<Integer>();
		for(Object i:a){
			list.add(Int(i));
		}return list.stream().mapToInt(Integer::intValue).toArray();}
	public static int[] Int(List<?> l){
		if(l.get(0).getClass()==Integer.class){
			return ((List<Integer>)l)
								.stream().mapToInt(Integer::intValue)
								.toArray();}
		return Int(l.toArray());}
	public static Byte[] bito(byte[] a){
		Byte[] b = new Byte[a.length];
		int p = 0;
		for(byte i:a){
			b[p++] = i;
		}return b;}
	
	public static long lowng(Object a){return Long.parseLong(str(a));}

	public static long[] lowng(Object[] a){
		long[] l = new long[a.length];
		int p = 0;
		for(Object i:a){
			l[p++] = lowng(i);
		}return l;}

	public static byte bait(Object a){return (Byte.valueOf(str(a)));}

	public static byte[] bait(Object[] a){
		byte[] b = new byte[a.length];
		int p = 0;
		for(Object i:a){
			b[p++] = bait(i);
		}return b;}
	public static int prim(Integer v){return ((int) v);}
	public static long prim(Long v){return ((long) v);}
	public static float prim(Float v){return ((float) v);}
	public static double prim(Double v){return ((double) v);}
	public static boolean prim(Boolean v){return ((boolean) v);}
	public static byte prim(Byte v){return ((byte) v);}
	public static char prim(Character v){return ((char) v);}
	public static short prim(Short v){return ((short) v);}
	public static int[] prim(Integer[] v){return Int(v);}
	public static byte[] prim(Byte[] v){return bait(v);}

	public static List<?> list(Object[] a){return Arrays.asList(a);}

	public static int len(Object[] array){return array.length;}
	public static int min(Integer[] array){return Collections.min(Arrays.asList(array));}
	public static int min(List<Integer> array){return Collections.min(array);}	
	public static int max(Integer[] array){return Collections.max(Arrays.asList(array));}
	public static int max(List<Integer> array){return Collections.max(array);}
	
	public static String type(Object obj){
		return obj.getClass().getName().replaceAll("java.lang.","");}
	public static String replace(String txt, String o,String n){return txt.replaceAll(o,n);}

	public static String input(){return new Scanner(System.in).nextLine();}
	public static String input(String p){println(p);return input();}

	public static void reverse(Object[] obj){Collections.reverse(list(obj));}
	public static void sorted(Object[] obj){Arrays.sort(obj);}
	public static void dir(Object a){
		if(a==null){print(a);return;}
		final HashSet<String> l = new HashSet<String>();
		for(Method mtd:a.getClass().getMethods()){l.add(mtd.getName());}
		print(l);}
	public static void help(Class<?> c){
		final String cn = c.getName().replace("java.lang.","");
		final Constructor<?>[] con = c.getConstructors();
		final Class<?>[] ci = c.getInterfaces();
		final Method[] m = c.getMethods();
		List<String> l = new ArrayList<String>();
		List<String> col = new ArrayList<String>();
		List<String> cl = new ArrayList<String>();
		char[] ca;
		List<String> p;
		Class<?>[] parameters;
		String r;
		for(Constructor<?> onc:con){
			parameters = onc.getParameterTypes();
			p = new ArrayList<String>();
			for(Class<?> x:parameters){
				p.add(x.getName().replace("java.lang.",""));}
			ca = str(p).replace(";","").toCharArray();ca[0]='(';ca[ca.length-1]=')';
			col.add(cn+String.valueOf(ca));}
		for(Class<?> in:ci){
			cl.add(in.getName().replace("java.lang.",""));
		}
		for(Method mtd:m){
			parameters = mtd.getParameterTypes();
			p = new ArrayList<String>();
			for(Class<?> x:parameters){
				p.add(x.getName().replace("java.lang.",""));}
			r = mtd.getReturnType().getName().replace("java.lang.","");
			ca = str(p).replace(";","").toCharArray();ca[0] = '(';ca[ca.length-1] = ')'; 
			l.add(Modifier.toString(mtd.getModifiers())+" "+mtd.getName()+String.valueOf(ca)+"->"+r);}
		print("About",cn,"class\n");
		print("Super Class:",c.getSuperclass().getName().replace("java.lang.",""));
		print("Modifiers:",Modifier.toString(c.getModifiers()));
		int i;
		if(cl.size()!=0)
		{println("Interfaces:");
		}else{print("No Interfaces");}
		cl.forEach(it -> println(it));
		if(col.size()!=0)
		{print("\nConstructors");print("------------");
		}else{print("No Constructors");}
		col.forEach(it -> print(it));
		print("\nMethods ");print("-------");
		l.forEach(it->print(it));
		l=null;col=null;
		parameters=null;r=null;cl=null;
		ca =null;p=null;
		System.gc();}
	public static void help(Object a){
		if(a==null){print(a);return;}
		help(a.getClass());}
	public static void help(){print("Usage:help(Object)\n      help(Class )");}
	public static int abs(int i){return Math.abs(i);}
	public static double abs(double i){return Math.abs(i);}
	public static String ReadFile(String filename){
		Reader file = new Reader(filename);
		String txt = file.read();
		file.close();
		return txt;}
	public static void WriteFile(String filename, Object obj){
		Reader file  = new Reader(filename,"w");
		file.write(str(obj));
		file.close();}
	public static void WriteFile(String filename, Object obj,Boolean overwrite){
		Reader file  = new Reader(filename,(overwrite?"a":"w"));
		file.write(str(obj));
		file.close();}
	public static float time(){return System.currentTimeMillis()/1000F;}
	final public String toString(){return "This class is used to simplify java with various function for easy coding.";}
}
