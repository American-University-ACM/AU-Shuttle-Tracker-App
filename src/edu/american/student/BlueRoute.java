package edu.american.student;

import java.util.ArrayList;

import android.util.Log;

import edu.american.student.util.LatLonPair;
import edu.american.student.util.LatLonPoint;



public class BlueRoute 
{
	ArrayList<LatLonPoint> route = new ArrayList<LatLonPoint>();
	ArrayList<String> busStopInfo = new ArrayList<String>();
	ArrayList<LatLonPoint> stops = new ArrayList<LatLonPoint>();
	
	public BlueRoute()
	{
		createRoute();
		createBusStops();
	}
	
	public ArrayList<LatLonPair> returnRoute()
	{
		ArrayList<LatLonPair> toReturn= new ArrayList<LatLonPair>();
		for(int i=1;i<route.size();i++)
		{
			toReturn.add(new LatLonPair(route.get(i-1),route.get(i)));
		}
		return toReturn;
	}
	public LatLonPoint getBusFromInfo(String info)
	{

		int[] returnVals = new int[busStopInfo.size()];
		
		for(int i=0;i<busStopInfo.size();i++)
		{
			returnVals[i]=stringCompare(busStopInfo.get(i),info);
		}
		int smallestIndex =-1;
		int smallestVal = 1000000;
		for(int i=0;i<returnVals.length;i++)
		{
			if(returnVals[i]<smallestVal && returnVals[i]<5)
			{
				smallestIndex=i;
				smallestVal = returnVals[i];
			}
		}
		if(smallestIndex ==-1)
		{
			return null;
		}
		return stops.get(smallestIndex);
	}
	private void createBusStops()
	{
		stops.add(new LatLonPoint(38.935194277922896,-77.09069967269897));
		stops.add(new LatLonPoint(38.93812348902975,-77.08815693855286));
		//stops.add(new LatLonPoint(38.93895799996236,-77.08491683006287));
		//stops.add(new LatLonPoint(38.94545850387772,-77.07932710647583));
		stops.add(new LatLonPoint(38.94956795011887,-77.07879602909088));
		stops.add(new LatLonPoint(38.94809525210452,-77.07875847816467));
		//stops.add(new LatLonPoint(38.945245724032326,-77.07975894212723));
		//stops.add(new LatLonPoint(38.94290510358263,-77.08174109458923));
		stops.add(new LatLonPoint(38.93885785916899,-77.08520650863647));
		stops.add(new LatLonPoint(38.93715544404418,-77.0866870880127));
		busStopInfo.add("Letts/Anderson Halls (South Campus)");
		busStopInfo.add("Kogod");
		//busStopInfo.add("Nebraska Hall (Metrobus stop across from Nebraska Hall)");
		//busStopInfo.add("Tenley Campus (Metrobus stop on Nebraska Ave. across from Tenley Campus)");
		busStopInfo.add("Brandywine (Brandywine and 40th Sts. NW, by request only)");
		busStopInfo.add("Tenleytown Metro Station (Albemarle and 40th Sts. NW)");
		//busStopInfo.add("Tenley Campus (Nebraska Ave. NW at second driveway to Tenley Campus)");
		//busStopInfo.add("Van Ness (Metrobus stop on Nebraska Ave. NW after crossing Van Ness St., by request only)");
		busStopInfo.add("Nebraska Hall (Metrobus stop on Nebraska Ave. before Ward Circle) - Admissions Green Room at the Katzen Arts Center Stop");
		busStopInfo.add("Ward Building (Metrobus stop on Nebraska Ave. outside of Ward Building)");
		
	}
	private void createRoute()
	{
		route.add(new LatLonPoint(38.93519010517121,-77.090705037117));
		route.add(new LatLonPoint(38.93554896091961,-77.09134876728058));
		route.add(new LatLonPoint(38.93559068821439,-77.09143459796906));
		route.add(new LatLonPoint(38.935557306380524,-77.09149360656738));
		route.add(new LatLonPoint(38.935828533325676,-77.0916759967804));
		route.add(new LatLonPoint(38.93600795981159,-77.09174036979675));
		route.add(new LatLonPoint(38.93619155853654,-77.09170818328857));
		route.add(new LatLonPoint(38.93636681142151,-77.0915687084198));
		route.add(new LatLonPoint(38.93647530108563,-77.0913702249527));
		route.add(new LatLonPoint(38.93655040921741,-77.09113955497742));
		route.add(new LatLonPoint(38.936558754560465,-77.09098935127258));
		route.add(new LatLonPoint(38.93638350214986,-77.09058165550232));
		route.add(new LatLonPoint(38.93635012068921,-77.09045827388763));
		route.add(new LatLonPoint(38.93632091189826,-77.09040462970734));
		route.add(new LatLonPoint(38.936717315892125,-77.09010422229767));
		route.add(new LatLonPoint(38.936800769082154,-77.08967506885529));
		route.add(new LatLonPoint(38.93685501360301,-77.0894980430603));
		route.add(new LatLonPoint(38.937401629151296,-77.08902597427368));
		route.add(new LatLonPoint(38.93746004583093,-77.08896696567535));
		route.add(new LatLonPoint(38.93737242079345,-77.08905816078186));
		route.add(new LatLonPoint(38.937397456529496,-77.08906888961792));
		route.add(new LatLonPoint(38.937798027104066,-77.08869874477386));
		route.add(new LatLonPoint(38.9378898242087,-77.08846271038055));
		route.add(new LatLonPoint(38.938236148579094,-77.08817303180695));
		route.add(new LatLonPoint(38.938549090832524,-77.08788871765137));
		route.add(new LatLonPoint(38.93855326338657,-77.08789944648743));
		route.add(new LatLonPoint(38.938728510434935,-77.08776533603668));
		route.add(new LatLonPoint(38.93889958451676,-77.08755612373352));
		route.add(new LatLonPoint(38.9389955527234,-77.08743274211884));
		route.add(new LatLonPoint(38.93838218846922,-77.08654224872589));
		route.add(new LatLonPoint(38.93826118401019,-77.08642423152924));
		route.add(new LatLonPoint(38.93816521480964,-77.086381316185));
		route.add(new LatLonPoint(38.938085935806875,-77.08636522293091));
		route.add(new LatLonPoint(38.93798162119452,-77.08635449409485));
		route.add(new LatLonPoint(38.93790234198649,-77.08635449409485));
		route.add(new LatLonPoint(38.93783558047941,-77.08635985851288));
		route.add(new LatLonPoint(38.93777716410915,-77.0863276720047));
		route.add(new LatLonPoint(38.937702057276695,-77.08630621433258));
		route.add(new LatLonPoint(38.93763112297298,-77.08625257015228));
		route.add(new LatLonPoint(38.93759356948932,-77.08615064620972));
		route.add(new LatLonPoint(38.93757270643428,-77.08609163761139));
		route.add(new LatLonPoint(38.93761443253826,-77.0859843492508));
		route.add(new LatLonPoint(38.937672849042585,-77.08587169647217));
		route.add(new LatLonPoint(38.937735438100944,-77.08575367927551));
		route.add(new LatLonPoint(38.93771874769078,-77.08579123020172));
		route.add(new LatLonPoint(38.937706229880575,-77.08578586578369));
		route.add(new LatLonPoint(38.93777299150944,-77.08569467067719));
		route.add(new LatLonPoint(38.93811931645042,-77.08558201789856));
		route.add(new LatLonPoint(38.93806924547922,-77.0855712890625));
		route.add(new LatLonPoint(38.93801917447266,-77.08559274673462));
		route.add(new LatLonPoint(38.93798162119452,-77.08560347557068));
		route.add(new LatLonPoint(38.93793155012607,-77.0856249332428));
		route.add(new LatLonPoint(38.93789816939413,-77.08561956882477));
		route.add(new LatLonPoint(38.93814017934465,-77.08551228046417));
		route.add(new LatLonPoint(38.93788565161561,-77.08561420440674));
		route.add(new LatLonPoint(38.93788147902229,-77.08564639091492));
		route.add(new LatLonPoint(38.93778133670863,-77.08568394184113));
		route.add(new LatLonPoint(38.93790651457859,-77.0856249332428));
		route.add(new LatLonPoint(38.9380525551476,-77.08557665348053));
		route.add(new LatLonPoint(38.93821945828676,-77.08554446697235));
		route.add(new LatLonPoint(38.93839053359671,-77.08543181419373));
		route.add(new LatLonPoint(38.93853657316891,-77.08534598350525));
		route.add(new LatLonPoint(38.938728510434935,-77.08516359329224));
		route.add(new LatLonPoint(38.938882894380605,-77.08506166934967));
		route.add(new LatLonPoint(38.93906231313838,-77.08487391471863));
		route.add(new LatLonPoint(38.93901641535983,-77.0849061012268));
		route.add(new LatLonPoint(38.939262594006195,-77.0847076177597));
		route.add(new LatLonPoint(38.93954215177163,-77.0844554901123));
		route.add(new LatLonPoint(38.93983422587164,-77.08422482013702));
		route.add(new LatLonPoint(38.9401721958287,-77.08393514156342));
		route.add(new LatLonPoint(38.940451750007945,-77.08368837833405));
		route.add(new LatLonPoint(38.94097747577754,-77.08323240280151));
		route.add(new LatLonPoint(38.94133630223914,-77.08294808864594));
		route.add(new LatLonPoint(38.94177022948783,-77.08257257938385));
		route.add(new LatLonPoint(38.94213322428084,-77.08224534988403));
		route.add(new LatLonPoint(38.942512906501065,-77.08192884922028));
		route.add(new LatLonPoint(38.942992721783085,-77.08152115345001));
		route.add(new LatLonPoint(38.943268092565354,-77.08130657672882));
		route.add(new LatLonPoint(38.94385638110783,-77.08079695701599));
		route.add(new LatLonPoint(38.9443403595112,-77.08041608333588));
		route.add(new LatLonPoint(38.94476175180961,-77.08006739616394));
		route.add(new LatLonPoint(38.945091353940825,-77.07982063293457));
		route.add(new LatLonPoint(38.945491881050415,-77.07947731018066));
		route.add(new LatLonPoint(38.945733865082545,-77.07924127578735));
		route.add(new LatLonPoint(38.94583816828992,-77.07915008068085));
		route.add(new LatLonPoint(38.94590909438329,-77.07920372486115));
		route.add(new LatLonPoint(38.94598002040568,-77.07918763160706));
		route.add(new LatLonPoint(38.94585068466449,-77.07918226718903));
		route.add(new LatLonPoint(38.94586320103685,-77.07908570766449));
		route.add(new LatLonPoint(38.945942471343834,-77.07893550395966));
		route.add(new LatLonPoint(38.946009225217814,-77.07879602909088));
		route.add(new LatLonPoint(38.946046774244294,-77.07864046096802));
		route.add(new LatLonPoint(38.94618445383792,-77.07851707935333));
		route.add(new LatLonPoint(38.94629710057925,-77.07842588424683));
		route.add(new LatLonPoint(38.946480672663114,-77.07843124866486));
		route.add(new LatLonPoint(38.94656411436223,-77.07849025726318));
		route.add(new LatLonPoint(38.94662252349319,-77.07853317260742));
		route.add(new LatLonPoint(38.94673099746588,-77.07842588424683));
		route.add(new LatLonPoint(38.94673099746588,-77.07845270633698));
		route.add(new LatLonPoint(38.94730674115769,-77.07853317260742));
		route.add(new LatLonPoint(38.94791168420176,-77.0785117149353));
		route.add(new LatLonPoint(38.949459480487405,-77.07853853702545));
		route.add(new LatLonPoint(38.94964304438187,-77.07854926586151));
		route.add(new LatLonPoint(38.9496847633825,-77.07864582538605));
		route.add(new LatLonPoint(38.94966390388525,-77.07874238491058));
		route.add(new LatLonPoint(38.94793671621652,-77.0787262916565));
		route.add(new LatLonPoint(38.94789499618704,-77.07858145236969));
		route.add(new LatLonPoint(38.947799040026105,-77.07852244377136));
		route.add(new LatLonPoint(38.947865792151795,-77.07851707935333));
		route.add(new LatLonPoint(38.94770308373527,-77.07852244377136));
		route.add(new LatLonPoint(38.947502826709886,-77.07852244377136));
		route.add(new LatLonPoint(38.9472316444196,-77.07852780818939));
		route.add(new LatLonPoint(38.94710648301265,-77.07850635051727));
		route.add(new LatLonPoint(38.94702304195193,-77.07848489284515));
		route.add(new LatLonPoint(38.946705965025394,-77.07843661308289));
		route.add(new LatLonPoint(38.94659331893374,-77.07853853702545));
		route.add(new LatLonPoint(38.94653073769435,-77.07848489284515));
		route.add(new LatLonPoint(38.94647650057557,-77.07845270633698));
		route.add(new LatLonPoint(38.94633882154915,-77.07837224006653));
		route.add(new LatLonPoint(38.94627206798554,-77.07841515541077));
		route.add(new LatLonPoint(38.94620948646257,-77.07845270633698));
		route.add(new LatLonPoint(38.94613021645416,-77.07852244377136));
		route.add(new LatLonPoint(38.946075979028926,-77.0785653591156));
		route.add(new LatLonPoint(38.94602591367647,-77.07869410514832));
		route.add(new LatLonPoint(38.945984192522424,-77.07881212234497));
		route.add(new LatLonPoint(38.94595498770001,-77.07883894443512));
		route.add(new LatLonPoint(38.945904922262116,-77.0789784193039));
		route.add(new LatLonPoint(38.94588406165256,-77.07902133464813));
		route.add(new LatLonPoint(38.94583816828992,-77.07911789417267));
		route.add(new LatLonPoint(38.94581730766072,-77.07917153835297));
		route.add(new LatLonPoint(38.945692143756624,-77.07924664020538));
		route.add(new LatLonPoint(38.94545015958209,-77.07946121692657));
		route.add(new LatLonPoint(38.94504546006504,-77.07979917526245));
		route.add(new LatLonPoint(38.94472420210249,-77.08008348941803));
		route.add(new LatLonPoint(38.94429446514923,-77.08041608333588));
		route.add(new LatLonPoint(38.943831347652285,-77.08079695701599));
		route.add(new LatLonPoint(38.94324305890206,-77.08131194114685));
		route.add(new LatLonPoint(38.942955171139005,-77.08153188228607));
		route.add(new LatLonPoint(38.942496217215414,-77.08193957805634));
		route.add(new LatLonPoint(38.94211653490583,-77.08225071430206));
		route.add(new LatLonPoint(38.941745195295645,-77.08257794380188));
		route.add(new LatLonPoint(38.94131544028528,-77.0829427242279));
		route.add(new LatLonPoint(38.94095244130547,-77.08325386047363));
		route.add(new LatLonPoint(38.94043506023712,-77.08367764949799));
		route.add(new LatLonPoint(38.9401555059921,-77.08393514156342));
		route.add(new LatLonPoint(38.939817535955484,-77.0842033624649));
		route.add(new LatLonPoint(38.939529634283325,-77.0844715833664));
		route.add(new LatLonPoint(38.93923338641489,-77.0847237110138));
		route.add(new LatLonPoint(38.939003897778704,-77.08491683006287));
		route.add(new LatLonPoint(38.93885368663287,-77.08505630493164));
		route.add(new LatLonPoint(38.9387118202585,-77.08515286445618));
		route.add(new LatLonPoint(38.93850736527853,-77.08532452583313));
		route.add(new LatLonPoint(38.938411396411155,-77.085480093956));
		route.add(new LatLonPoint(38.9383863610331,-77.08557665348053));
		route.add(new LatLonPoint(38.9383195999817,-77.08569467067719));
		route.add(new LatLonPoint(38.938240321151554,-77.08585560321808));
		route.add(new LatLonPoint(38.93811514387084,-77.08606481552124));
		route.add(new LatLonPoint(38.9380525551476,-77.08612382411957));
		route.add(new LatLonPoint(38.93797327601891,-77.08619892597198));
		route.add(new LatLonPoint(38.93788565161561,-77.08621501922607));
		route.add(new LatLonPoint(38.93781889009283,-77.0862203836441));
		route.add(new LatLonPoint(38.93761443253826,-77.0862203836441));
		route.add(new LatLonPoint(38.937568533822535,-77.08628475666046));
		route.add(new LatLonPoint(38.93747673630199,-77.08629548549652));
		route.add(new LatLonPoint(38.937368248169925,-77.08637058734894));
		route.add(new LatLonPoint(38.937026092204704,-77.08670318126678));
		route.add(new LatLonPoint(38.93663386260387,-77.08701968193054));
		route.add(new LatLonPoint(38.93626666696884,-77.08732008934021));
		route.add(new LatLonPoint(38.9358744331676,-77.0876795053482));
		route.add(new LatLonPoint(38.93556147911064,-77.08792626857758));
		route.add(new LatLonPoint(38.93539039697563,-77.08811938762665));
		route.add(new LatLonPoint(38.93513168662169,-77.08844125270844));
		route.add(new LatLonPoint(38.93493556685351,-77.08870947360992));
		route.add(new LatLonPoint(38.93474361932119,-77.08897769451141));
		route.add(new LatLonPoint(38.934601744724255,-77.08917617797852));
		route.add(new LatLonPoint(38.93457253521319,-77.0892459154129));
		route.add(new LatLonPoint(38.93451828894642,-77.08981454372406));
		route.add(new LatLonPoint(38.93471858264823,-77.08993792533875));
		route.add(new LatLonPoint(38.93481038373917,-77.09008276462555));
		route.add(new LatLonPoint(38.93496477621506,-77.09034562110901));
		route.add(new LatLonPoint(38.93514420488635,-77.09059774875641));
		route.add(new LatLonPoint(38.935169241409035,-77.0906674861908));
		
	}


	public String getBusInfo(LatLonPoint location)
	{
		int j=-1;
		for(int i=0;i<stops.size();i++)
		{
			if(stops.get(i).equals(location))
			{
				j=i;
			}
		}
		if(j !=-1)
		{
			return busStopInfo.get(j);
		}
		return "Unknown Stop";
	}
	public ArrayList<LatLonPoint> returnBusStops()
	{
		return stops;
	}
	
	public int stringCompare(String a, String b)
	{
		Log.e("size a",a.length()+"");
		Log.e("size b",b.length()+"");
		char[] aArr = a.toCharArray();
		char[] bArr = b.toCharArray();
	
		int returnVal =0;
		if(aArr.length<= bArr.length)
		{
			for(int i=0;i<aArr.length;i++)
			{
				if(aArr[i] != bArr[i])
				{
					returnVal++;
				}
			}
		}
		else
		{
			for(int i=0;i<bArr.length;i++)
			{
				if(aArr[i] != bArr[i])
				{
					returnVal++;
				}
			}
		}
		return returnVal;
	}
}
