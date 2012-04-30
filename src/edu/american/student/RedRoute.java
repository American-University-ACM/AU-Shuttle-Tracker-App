package edu.american.student;

import java.util.ArrayList;

import android.util.Log;

import edu.american.student.util.LatLonPair;
import edu.american.student.util.LatLonPoint;

/**
 * This class holds all info on the Red Route
 * @author Cam Cook
 *
 */
public class RedRoute 
{

	ArrayList<LatLonPoint> route = new ArrayList<LatLonPoint>();// route defintions
	ArrayList<LatLonPoint> busStops = new ArrayList<LatLonPoint>();// bus stop definitions 
	ArrayList<String> busStopInfo = new ArrayList<String>(); // bus stop info
	
	/**
	 * On init, it populates the route and busStops
	 */
	public RedRoute()
	{
		createRoute();
		createBusStops();
	}
	
	/**
	 * From an info string it returns the bus stop location closest to that info
	 * @param info the info string
	 * @return the bus location closest to that info
	 */
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
		return busStops.get(smallestIndex);
	}
	
	/**
	 * From a location, it returns the info of that stop
	 * @param location the location of the stop
	 * @return the info on that stop
	 */
	public String getBusInfo(LatLonPoint location)
	{
		int j=-1;
		for(int i=0;i<busStops.size();i++)
		{
			if(busStops.get(i).equals(location))
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

	/**
	 * Defines the bus stops<br>
	 * Notice that the shared routes are commented out (see SharedRoute)
	 */
	private void createBusStops() 
	{
		busStops.add(new LatLonPoint(38.938398878723234,-77.086740732193));
		busStops.add(new LatLonPoint(38.93892461971362,-77.08712697029114));
		busStops.add(new LatLonPoint(38.94473254648357,-77.09457278251648));
		//busStops.add(new LatLonPoint(38.93895799996236,-77.08491683006287));
		//busStops.add(new LatLonPoint(38.9456587666782,-77.07915544509888));
		busStops.add(new LatLonPoint(38.9487544238369,-77.07834005355835));
		//busStops.add(new LatLonPoint(38.94522486322879,-77.07975625991821));
		/*busStops.add(new LatLonPoint(38.94336822713008,-77.08116710186005));
		busStops.add(new LatLonPoint(38.94299689407566,-77.08176255226135));*/
		busStops.add(new LatLonPoint(38.94624286328169,-77.09649324417114));
		
		busStopInfo.add("Massachusetts Ave. (Metrobus stop on Massachusetts Ave. across from the Katzen Arts Center)");
		busStopInfo.add("Katzen (Metrobus stop on Massachusetts Ave. in front of Katzen Arts Center) - Admissions Green Room at the Katzen Arts Center Stop");
		busStopInfo.add("WCL (side of law school on 48th St.)");
		//busStopInfo.add("Nebraska Hall (Metrobus stop on Nebraska Ave. across from Nebraska Hall)");
		//busStopInfo.add("Tenley Campus toward Metro (Metrobus stop on Nebraska Ave. across from Tenley Campus)");
		busStopInfo.add("Tenleytown Metro Station (40th St. across from Tenleytown Metro station)");
		//busStopInfo.add("Tenley Campus toward WCL (Nebraska Ave. NW at second driveway to Tenley Campus)");
		/*busStopInfo.add("Van Ness toward Metro (upon request)");
		busStopInfo.add("Van Ness toward WCL (upon request)");*/
		busStopInfo.add("Yuma St. (Metrobus stop at 49th and Yuma Sts.)");
	}

	/**
	 * returns the route definitions
	 * @return the route definitions
	 */
	public ArrayList<LatLonPair> returnRoute()
	{
		ArrayList<LatLonPair> toReturn= new ArrayList<LatLonPair>();
		for(int i=1;i<route.size();i++)
		{
			toReturn.add(new LatLonPair(route.get(i-1),route.get(i)));
		}
		return toReturn;
	}

	/**
	 * returns busStop definitions
	 * @return busStop definitions
	 */
	public ArrayList<LatLonPoint> returnBusStops()
	{
		return busStops;
	}

	/**
	 * populates the route definitions
	 */
	private void createRoute()
	{
		route.add(new LatLonPoint(38.94492342393254,-77.09434077143669));
		route.add(new LatLonPoint(38.94489526171829,-77.09434077143669));
		route.add(new LatLonPoint(38.94486501340165,-77.09433943033218));
		route.add(new LatLonPoint(38.944841023348225,-77.0943421125412));
		route.add(new LatLonPoint(38.944822248518136,-77.09433943033218));
		route.add(new LatLonPoint(38.94480034454345,-77.09433943033218));
		route.add(new LatLonPoint(38.94478574188986,-77.09433808922768));
		route.add(new LatLonPoint(38.94477426837425,-77.09433943033218));
		route.add(new LatLonPoint(38.94476070876247,-77.0943608880043));
		route.add(new LatLonPoint(38.9447471491481,-77.09437966346741));
		route.add(new LatLonPoint(38.94474297695856,-77.09438771009445));
		route.add(new LatLonPoint(38.94473358953116,-77.094397097826));
		route.add(new LatLonPoint(38.94472420210249,-77.09440782666206));
		route.add(new LatLonPoint(38.944713771624784,-77.09441855549812));
		route.add(new LatLonPoint(38.944702298097496,-77.09442526102066));
		route.add(new LatLonPoint(38.94468769542373,-77.09444269537926));
		route.add(new LatLonPoint(38.944665791407466,-77.09446683526039));
		route.add(new LatLonPoint(38.94464388738441,-77.09449097514153));
		route.add(new LatLonPoint(38.94461989725617,-77.09450840950012));
		route.add(new LatLonPoint(38.9446355429929,-77.09449835121632));
		route.add(new LatLonPoint(38.94462354792838,-77.09451109170914));
		route.add(new LatLonPoint(38.94461311743584,-77.09451980888844));
		route.add(new LatLonPoint(38.944607380664294,-77.09453254938126));
		route.add(new LatLonPoint(38.94459695016936,-77.0945405960083));
		route.add(new LatLonPoint(38.94458860577233,-77.09454998373985));
		route.add(new LatLonPoint(38.944580261374306,-77.0945593714714));
		route.add(new LatLonPoint(38.94457348155019,-77.09456607699394));
		route.add(new LatLonPoint(38.94456774477544,-77.09457479417324));
		route.add(new LatLonPoint(38.94455940037497,-77.09458149969578));
		route.add(new LatLonPoint(38.94454896987299,-77.09458887577057));
		route.add(new LatLonPoint(38.94455001292325,-77.09459021687508));
		route.add(new LatLonPoint(38.944544276146594,-77.09459759294987));
		route.add(new LatLonPoint(38.9445364532686,-77.09460832178593));
		route.add(new LatLonPoint(38.94452810886442,-77.09461636841297));
		route.add(new LatLonPoint(38.944520285984645,-77.09462307393551));
		route.add(new LatLonPoint(38.94451454920557,-77.0946304500103));
		route.add(new LatLonPoint(38.94450724784974,-77.09463581442833));
		route.add(new LatLonPoint(38.944502554120575,-77.09464319050312));
		route.add(new LatLonPoint(38.944496295814574,-77.0946492254734));
		route.add(new LatLonPoint(38.94449160208469,-77.09465391933918));
		route.add(new LatLonPoint(38.9444858653033,-77.09465995430946));
		route.add(new LatLonPoint(38.944480128521455,-77.09466598927975));
		route.add(new LatLonPoint(38.94447491326483,-77.09467135369778));
		route.add(new LatLonPoint(38.94447074105925,-77.09467604756355));
		route.add(new LatLonPoint(38.944466047327694,-77.09468275308609));
		route.add(new LatLonPoint(38.94446187512158,-77.09468811750412));
		route.add(new LatLonPoint(38.944456659863604,-77.09469214081764));
		route.add(new LatLonPoint(38.94445144460525,-77.09469683468342));
		route.add(new LatLonPoint(38.944446750872416,-77.09470421075821));
		route.add(new LatLonPoint(38.94444153561332,-77.09470823407173));
		route.add(new LatLonPoint(38.944436320353866,-77.09471292793751));
		route.add(new LatLonPoint(38.944433191197994,-77.09471896290779));
		route.add(new LatLonPoint(38.94443006204199,-77.09472231566906));
		route.add(new LatLonPoint(38.94442484678167,-77.09472768008709));
		route.add(new LatLonPoint(38.94442119609923,-77.09473438560963));
		route.add(new LatLonPoint(38.94441754541661,-77.09473706781864));
		route.add(new LatLonPoint(38.94441337320765,-77.09474243223667));
		route.add(new LatLonPoint(38.94441024405078,-77.0947464555502));
		route.add(new LatLonPoint(38.944407114893764,-77.09475047886372));
		route.add(new LatLonPoint(38.944405028789014,-77.09475383162498));
		route.add(new LatLonPoint(38.94440137810553,-77.09475181996822));
		route.add(new LatLonPoint(38.94439981352684,-77.09474444389343));
		route.add(new LatLonPoint(38.94439459826431,-77.0947390794754));
		route.add(new LatLonPoint(38.94438990452771,-77.09473572671413));
		route.add(new LatLonPoint(38.94438573231712,-77.09472633898258));
		route.add(new LatLonPoint(38.944380517053546,-77.09471963346004));
		route.add(new LatLonPoint(38.94437686636881,-77.09471426904202));
		route.add(new LatLonPoint(38.94437217263105,-77.09471091628075));
		route.add(new LatLonPoint(38.94436852194588,-77.09470421075821));
		route.add(new LatLonPoint(38.94436226362802,-77.09469616413116));
		route.add(new LatLonPoint(38.94435861294235,-77.09469214081764));
		route.add(new LatLonPoint(38.9443549622565,-77.09468677639961));
		route.add(new LatLonPoint(38.94434974699066,-77.09468007087708));
		route.add(new LatLonPoint(38.94434453172447,-77.09467269480228));
		route.add(new LatLonPoint(38.944339837984536,-77.09466598927975));
		route.add(new LatLonPoint(38.9443351442443,-77.09465995430946));
		route.add(new LatLonPoint(38.94432888592349,-77.09465324878693));
		route.add(new LatLonPoint(38.944324713709314,-77.09464587271214));
		route.add(new LatLonPoint(38.94431480469968,-77.09463648498058));
		route.add(new LatLonPoint(38.944306981796366,-77.09462307393551));
		route.add(new LatLonPoint(38.9442934220952,-77.09460228681564));
		route.add(new LatLonPoint(38.94427516864726,-77.09457814693451));
		route.add(new LatLonPoint(38.94425378603083,-77.09455266594887));
		route.add(new LatLonPoint(38.94424439853865,-77.09453657269478));
		route.add(new LatLonPoint(38.944235532572684,-77.09452785551548));
		route.add(new LatLonPoint(38.944227188133084,-77.09451176226139));
		route.add(new LatLonPoint(38.94421102077862,-77.09448762238026));
		route.add(new LatLonPoint(38.94419850411456,-77.09447152912617));
		route.add(new LatLonPoint(38.944178164530754,-77.09444537758827));
		route.add(new LatLonPoint(38.944164083276995,-77.09442660212517));
		route.add(new LatLonPoint(38.9441578249411,-77.09441587328911));
		route.add(new LatLonPoint(38.944147915908125,-77.0944058150053));
		route.add(new LatLonPoint(38.944140092986395,-77.09439039230347));
		route.add(new LatLonPoint(38.94412809783804,-77.09437698125839));
		route.add(new LatLonPoint(38.944113495046004,-77.09435351192951));
		route.add(new LatLonPoint(38.94410254295,-77.09434077143669));
		route.add(new LatLonPoint(38.94409419849475,-77.09432668983936));
		route.add(new LatLonPoint(38.944086897095644,-77.09431394934654));
		route.add(new LatLonPoint(38.944076466524145,-77.09430187940598));
		route.add(new LatLonPoint(38.94406447136503,-77.09428779780865));
		route.add(new LatLonPoint(38.94405404079025,-77.09427237510681));
		route.add(new LatLonPoint(38.944039959511834,-77.09425494074821));
		route.add(new LatLonPoint(38.94402952893344,-77.09423951804638));
		route.add(new LatLonPoint(38.94401440459204,-77.09421940147877));
		route.add(new LatLonPoint(38.94400240942242,-77.09419794380665));
		route.add(new LatLonPoint(38.94398832813374,-77.09418050944805));
		route.add(new LatLonPoint(38.94397163919543,-77.09416173398495));
		route.add(new LatLonPoint(38.943959644018584,-77.09414228796959));
		route.add(new LatLonPoint(38.94395025648745,-77.09412887692451));
		route.add(new LatLonPoint(38.94386107487977,-77.09400214254856));
		route.add(new LatLonPoint(38.94376302713483,-77.0938653498888));
		route.add(new LatLonPoint(38.94368949123716,-77.09376409649849));
		route.add(new LatLonPoint(38.94363212275336,-77.09368631243706));
		route.add(new LatLonPoint(38.943598223172955,-77.0936407148838));
		route.add(new LatLonPoint(38.94357266809393,-77.09360383450985));
		route.add(new LatLonPoint(38.94354189768042,-77.09356561303139));
		route.add(new LatLonPoint(38.9435231225063,-77.09353342652321));
		route.add(new LatLonPoint(38.94350486886002,-77.09351062774658));
		route.add(new LatLonPoint(38.94349183053838,-77.09349185228348));
		route.add(new LatLonPoint(38.94346940461953,-77.09346167743206));
		route.add(new LatLonPoint(38.943438634161204,-77.09341742098331));
		route.add(new LatLonPoint(38.943411514424156,-77.09338054060936));
		route.add(new LatLonPoint(38.943382308541906,-77.09334097802639));
		route.add(new LatLonPoint(38.943360404122295,-77.09330879151821));
		route.add(new LatLonPoint(38.94333589202567,-77.09327459335327));
		route.add(new LatLonPoint(38.9433176383312,-77.09325112402439));
		route.add(new LatLonPoint(38.94329938463202,-77.09322363138199));
		route.add(new LatLonPoint(38.94327539404881,-77.09319211542606));
		route.add(new LatLonPoint(38.94325661880411,-77.09316529333591));
		route.add(new LatLonPoint(38.943220632904534,-77.09311567246914));
		route.add(new LatLonPoint(38.94319716382975,-77.0930828154087));
		route.add(new LatLonPoint(38.943184646986694,-77.09306336939335));
		route.add(new LatLonPoint(38.94316587171797,-77.09303922951221));
		route.add(new LatLonPoint(38.943141881089595,-77.09300637245178));
		route.add(new LatLonPoint(38.943130928843495,-77.09299094974995));
		route.add(new LatLonPoint(38.94312154120262,-77.09297887980938));
		route.add(new LatLonPoint(38.943104852060245,-77.0929554104805));
		route.add(new LatLonPoint(38.94309337827259,-77.09294401109219));
		route.add(new LatLonPoint(38.94307825373147,-77.09293328225613));
		route.add(new LatLonPoint(38.94306469379533,-77.09292389452457));
		route.add(new LatLonPoint(38.943052698465024,-77.09291651844978));
		route.add(new LatLonPoint(38.94304331081382,-77.09290646016598));
		route.add(new LatLonPoint(38.94303027240727,-77.0928843319416));
		route.add(new LatLonPoint(38.94302610011669,-77.0928829908371));
		route.add(new LatLonPoint(38.94299898022183,-77.09284543991089));
		route.add(new LatLonPoint(38.94298020490395,-77.092819288373));
		route.add(new LatLonPoint(38.94296455880189,-77.09279917180538));
		route.add(new LatLonPoint(38.94295152038089,-77.09278374910355));
		route.add(new LatLonPoint(38.94293483119849,-77.0927582681179));
		route.add(new LatLonPoint(38.94291918508644,-77.09273748099804));
		route.add(new LatLonPoint(38.942899366672876,-77.09271132946014));
		route.add(new LatLonPoint(38.94288059132858,-77.09268450737));
		route.add(new LatLonPoint(38.94286494520456,-77.09266506135464));
		route.add(new LatLonPoint(38.94285086369,-77.09264360368252));
		route.add(new LatLonPoint(38.94283626063486,-77.09262482821941));
		route.add(new LatLonPoint(38.94282322219028,-77.09260538220406));
		route.add(new LatLonPoint(38.94280757605359,-77.09258794784546));
		route.add(new LatLonPoint(38.9427934945276,-77.09256917238235));
		route.add(new LatLonPoint(38.942778891460684,-77.0925423502922));
		route.add(new LatLonPoint(38.94279818836992,-77.09257118403912));
		route.add(new LatLonPoint(38.94278462838019,-77.09255307912827));
		route.add(new LatLonPoint(38.94277158992609,-77.09253363311291));
		route.add(new LatLonPoint(38.94275750839297,-77.0925135165453));
		route.add(new LatLonPoint(38.94274446993388,-77.09249407052994));
		route.add(new LatLonPoint(38.94272517301002,-77.09246724843979));
		route.add(new LatLonPoint(38.94270483300353,-77.09243774414062));
		route.add(new LatLonPoint(38.94268553606888,-77.09240891039371));
		route.add(new LatLonPoint(38.94266988990181,-77.0923874527216));
		route.add(new LatLonPoint(38.94265163603587,-77.09236063063145));
		route.add(new LatLonPoint(38.94263025292978,-77.09232844412327));
		route.add(new LatLonPoint(38.94261356367176,-77.09230564534664));
		route.add(new LatLonPoint(38.94259948210725,-77.09228619933128));
		route.add(new LatLonPoint(38.9425791420647,-77.09225736558437));
		route.add(new LatLonPoint(38.9425619312549,-77.09223456680775));
		route.add(new LatLonPoint(38.9425452419808,-77.09220707416534));
		route.add(new LatLonPoint(38.94252490192269,-77.09217958152294));
		route.add(new LatLonPoint(38.942507691099706,-77.09215208888054));
		route.add(new LatLonPoint(38.94249100181286,-77.09212996065617));
		route.add(new LatLonPoint(38.94247483406246,-77.09210649132729));
		route.add(new LatLonPoint(38.942452929362474,-77.0920743048191));
		route.add(new LatLonPoint(38.94243102465575,-77.0920454710722));
		route.add(new LatLonPoint(38.94241329226915,-77.09201999008656));
		route.add(new LatLonPoint(38.942400253746754,-77.09199920296669));
		route.add(new LatLonPoint(38.94237730594153,-77.09196969866753));
		route.add(new LatLonPoint(38.94235070733981,-77.0919294655323));
		route.add(new LatLonPoint(38.942334018016,-77.09190666675568));
		route.add(new LatLonPoint(38.94231837177135,-77.09188520908356));
		route.add(new LatLonPoint(38.942304811689866,-77.0918671041727));
		route.add(new LatLonPoint(38.94228499310455,-77.09184430539608));
		route.add(new LatLonPoint(38.94226256680398,-77.09181278944016));
		route.add(new LatLonPoint(38.94223909741206,-77.09178395569324));
		route.add(new LatLonPoint(38.94221980035067,-77.09175646305084));
		route.add(new LatLonPoint(38.94219737402947,-77.09172829985619));
		route.add(new LatLonPoint(38.94215617216508,-77.09167398512363));
		route.add(new LatLonPoint(38.94212279342192,-77.09163308143616));
		route.add(new LatLonPoint(38.9420748114511,-77.09157139062881));
		route.add(new LatLonPoint(38.94201431239814,-77.09149159491062));
		route.add(new LatLonPoint(38.94197884741208,-77.09144398570061));
		route.add(new LatLonPoint(38.941927214532974,-77.09137827157974));
		route.add(new LatLonPoint(38.94187766779548,-77.09131591022015));
		route.add(new LatLonPoint(38.94184741819134,-77.09127567708492));
		route.add(new LatLonPoint(38.94180517303295,-77.09122069180012));
		route.add(new LatLonPoint(38.941778052671054,-77.09118381142616));
		route.add(new LatLonPoint(38.94175145384452,-77.09115028381348));
		route.add(new LatLonPoint(38.94171703181892,-77.09110870957375));
		route.add(new LatLonPoint(38.94170242853026,-77.09108859300613));
		route.add(new LatLonPoint(38.9416831313228,-77.09106042981148));
		route.add(new LatLonPoint(38.941661747924634,-77.09103025496006));
		route.add(new LatLonPoint(38.94163201977497,-77.0909933745861));
		route.add(new LatLonPoint(38.94159186067581,-77.09094375371933));
		route.add(new LatLonPoint(38.9415663048736,-77.09090888500214));
		route.add(new LatLonPoint(38.94154700762908,-77.0908834040165));
		route.add(new LatLonPoint(38.94151310705169,-77.09083914756775));
		route.add(new LatLonPoint(38.941474512528444,-77.09079086780548));
		route.add(new LatLonPoint(38.94142027154137,-77.09071509540081));
		route.add(new LatLonPoint(38.9413978449673,-77.09068357944489));
		route.add(new LatLonPoint(38.94134256082411,-77.09060713648796));
		route.add(new LatLonPoint(38.94127267326069,-77.09050454199314));
		route.add(new LatLonPoint(38.941271108612945,-77.0905052125454));
		route.add(new LatLonPoint(38.941200699429324,-77.09040597081184));
		route.add(new LatLonPoint(38.941129768625494,-77.09030605852604));
		route.add(new LatLonPoint(38.94105935930152,-77.09020413458347));
		route.add(new LatLonPoint(38.9409889499076,-77.09010757505894));
		route.add(new LatLonPoint(38.940919583547476,-77.09001168608665));
		route.add(new LatLonPoint(38.9408476093577,-77.08991311490536));
		route.add(new LatLonPoint(38.94077511354194,-77.08981588482857));
		route.add(new LatLonPoint(38.940703660758935,-77.08971865475178));
		route.add(new LatLonPoint(38.940632729457874,-77.08962209522724));
		route.add(new LatLonPoint(38.94055553943197,-77.0895168185234));
		route.add(new LatLonPoint(38.940482521762554,-77.08941958844662));
		route.add(new LatLonPoint(38.94040898246238,-77.0893183350563));
		route.add(new LatLonPoint(38.940338572422625,-77.08922110497952));
		route.add(new LatLonPoint(38.94026503297314,-77.08912052214146));
		route.add(new LatLonPoint(38.94019879524769,-77.08903133869171));
		route.add(new LatLonPoint(38.94014768262982,-77.08896227180958));
		route.add(new LatLonPoint(38.94011169515229,-77.08891533315182));
		route.add(new LatLonPoint(38.94005641000631,-77.08884090185165));
		route.add(new LatLonPoint(38.93998443494033,-77.08874434232712));
		route.add(new LatLonPoint(38.93991245980129,-77.08864510059357));
		route.add(new LatLonPoint(38.93984048458918,-77.08854585886002));
		route.add(new LatLonPoint(38.93977007398492,-77.08844996988773));
		route.add(new LatLonPoint(38.93969809862831,-77.08835005760193));
		route.add(new LatLonPoint(38.93956405737087,-77.08816565573215));
		route.add(new LatLonPoint(38.93948999555573,-77.0880650728941));
		route.add(new LatLonPoint(38.93942062772917,-77.08796985447407));
		route.add(new LatLonPoint(38.93934500107401,-77.08786390721798));
		route.add(new LatLonPoint(38.93927667623344,-77.08777405321598));
		route.add(new LatLonPoint(38.93920417881152,-77.08767749369144));
		route.add(new LatLonPoint(38.9391337675754,-77.0875782519579));
		route.add(new LatLonPoint(38.93906335626938,-77.08748303353786));
		route.add(new LatLonPoint(38.939005462476494,-77.08740256726742));
		route.add(new LatLonPoint(38.938909494283244,-77.08727315068245));
		route.add(new LatLonPoint(38.93884169059014,-77.0871826261282));
		route.add(new LatLonPoint(38.93876867115585,-77.08707936108112));
		route.add(new LatLonPoint(38.93869878105544,-77.0869841426611));
		route.add(new LatLonPoint(38.93863045559219,-77.08688959479332));
		route.add(new LatLonPoint(38.9385584790788,-77.08679303526878));
		route.add(new LatLonPoint(38.938483894643625,-77.08669178187847));
		route.add(new LatLonPoint(38.93841869839477,-77.08659522235394));
		route.add(new LatLonPoint(38.93841087484087,-77.08658583462238));
		route.add(new LatLonPoint(38.938388968885384,-77.08656504750252));
		route.add(new LatLonPoint(38.938369149205556,-77.0865449309349));
		route.add(new LatLonPoint(38.93834359224178,-77.08651944994926));
		route.add(new LatLonPoint(38.93832690197477,-77.08650335669518));
		route.add(new LatLonPoint(38.93831125484587,-77.0864886045456));
		route.add(new LatLonPoint(38.93828987043079,-77.08646848797798));
		route.add(new LatLonPoint(38.93827109386588,-77.08644904196262));
		route.add(new LatLonPoint(38.93825701143895,-77.08643764257431));
		route.add(new LatLonPoint(38.93824136429461,-77.086426243186));
		route.add(new LatLonPoint(38.93822310928856,-77.08641082048416));
		route.add(new LatLonPoint(38.93820016013139,-77.08639673888683));
		route.add(new LatLonPoint(38.93817512467874,-77.0863900333643));
		route.add(new LatLonPoint(38.93815008921727,-77.08638332784176));
		route.add(new LatLonPoint(38.93812766160885,-77.08637796342373));
		route.add(new LatLonPoint(38.93810523399334,-77.08637058734894));
		route.add(new LatLonPoint(38.938078633789004,-77.0863638818264));
		route.add(new LatLonPoint(38.93805881402244,-77.08635918796062));
		route.add(new LatLonPoint(38.93804160211537,-77.08635449409485));
		route.add(new LatLonPoint(38.93803064908143,-77.08634980022907));
		route.add(new LatLonPoint(38.938018131326295,-77.08635114133358));
		route.add(new LatLonPoint(38.938010829301454,-77.08635315299034));
		route.add(new LatLonPoint(38.93800039783607,-77.08635583519936));
		route.add(new LatLonPoint(38.937993095809375,-77.08635784685612));
		route.add(new LatLonPoint(38.93798214276796,-77.08635918796062));
		route.add(new LatLonPoint(38.9379727544454,-77.0863625407219));
		route.add(new LatLonPoint(38.93796336612159,-77.0863625407219));
		route.add(new LatLonPoint(38.93795762881198,-77.08636187016964));
		route.add(new LatLonPoint(38.93794980520721,-77.08636187016964));
		route.add(new LatLonPoint(38.93793885215908,-77.08636321127415));
		route.add(new LatLonPoint(38.9379294638308,-77.0863638818264));
		route.add(new LatLonPoint(38.93791485976206,-77.0863638818264));
		route.add(new LatLonPoint(38.93790025569035,-77.0863638818264));
		route.add(new LatLonPoint(38.937877828002904,-77.08636321127415));
		route.add(new LatLonPoint(38.9378616592006,-77.08636187016964));
		route.add(new LatLonPoint(38.937840796224414,-77.08635650575161));
		route.add(new LatLonPoint(38.93781106647274,-77.08635248243809));
		route.add(new LatLonPoint(38.93778550930786,-77.08634175360203));
		route.add(new LatLonPoint(38.93774274015416,-77.08632230758667));
		route.add(new LatLonPoint(38.93771822611538,-77.08630688488483));
		route.add(new LatLonPoint(38.93770257885219,-77.08629481494427));
		route.add(new LatLonPoint(38.93768901788794,-77.08628475666046));
		route.add(new LatLonPoint(38.93766919801247,-77.08626933395863));
		route.add(new LatLonPoint(38.93765928807266,-77.08625994622707));
		route.add(new LatLonPoint(38.93764677025195,-77.0862478762865));
		route.add(new LatLonPoint(38.937631644548986,-77.08622373640537));
		route.add(new LatLonPoint(38.937618083571174,-77.08619624376297));
		route.add(new LatLonPoint(38.937601393133406,-77.08617143332958));
		route.add(new LatLonPoint(38.93758209480982,-77.08613455295563));
		route.add(new LatLonPoint(38.93757374958719,-77.08611510694027));
		route.add(new LatLonPoint(38.93756905539903,-77.08610907196999));
		route.add(new LatLonPoint(38.93757322801075,-77.08609633147717));
		route.add(new LatLonPoint(38.937579486927845,-77.08607755601406));
		route.add(new LatLonPoint(38.93758991845514,-77.08605475723743));
		route.add(new LatLonPoint(38.93759826367588,-77.08603195846081));
		route.add(new LatLonPoint(38.93761078150514,-77.08600714802742));
		route.add(new LatLonPoint(38.93762642878861,-77.08597294986248));
		route.add(new LatLonPoint(38.937638946612886,-77.08594679832458));
		route.add(new LatLonPoint(38.93764989970733,-77.0859219878912));
		route.add(new LatLonPoint(38.93766346067906,-77.08589516580105));
		route.add(new LatLonPoint(38.93767702164817,-77.0858696848154));
		route.add(new LatLonPoint(38.937691625765886,-77.085842192173));
		route.add(new LatLonPoint(38.9377057083051,-77.08582140505314));
		route.add(new LatLonPoint(38.93771926926615,-77.08579994738102));
		route.add(new LatLonPoint(38.93773752440192,-77.08577312529087));
		route.add(new LatLonPoint(38.93775734425831,-77.08575166761875));
		route.add(new LatLonPoint(38.93777768568411,-77.08573155105114));
		route.add(new LatLonPoint(38.93779854867885,-77.08571210503578));
		route.add(new LatLonPoint(38.93782097639136,-77.08569265902042));
		route.add(new LatLonPoint(38.93784340409677,-77.08567656576633));
		route.add(new LatLonPoint(38.93786687494368,-77.08565644919872));
		route.add(new LatLonPoint(38.937896604671934,-77.08564706146717));
		route.add(new LatLonPoint(38.9379221617968,-77.08563432097435));
		route.add(new LatLonPoint(38.93795554251744,-77.08562090992928));
		route.add(new LatLonPoint(38.93799518210282,-77.08560883998871));
		route.add(new LatLonPoint(38.93803482166598,-77.08559945225716));
		route.add(new LatLonPoint(38.938068202333596,-77.0855900645256));
		route.add(new LatLonPoint(38.93810262613061,-77.08558268845081));
		route.add(new LatLonPoint(38.93813026947067,-77.08557665348053));
		route.add(new LatLonPoint(38.93816260694912,-77.0855712890625));
		route.add(new LatLonPoint(38.93818294825864,-77.08556056022644));
		route.add(new LatLonPoint(38.93820589742138,-77.08555117249489));
		route.add(new LatLonPoint(38.93823041129154,-77.08553977310658));
		route.add(new LatLonPoint(38.93825648986753,-77.08552435040474));
		route.add(new LatLonPoint(38.938278395863954,-77.08551429212093));
		route.add(new LatLonPoint(38.93830499599335,-77.08550155162811));
		route.add(new LatLonPoint(38.93832377254925,-77.08549417555332));
		route.add(new LatLonPoint(38.93834620009564,-77.08547741174698));
		route.add(new LatLonPoint(38.93836758449374,-77.08546802401543));
		route.add(new LatLonPoint(38.93839783558247,-77.08545126020908));
		route.add(new LatLonPoint(38.93842182781608,-77.08544254302979));
		route.add(new LatLonPoint(38.9384463416116,-77.08543047308922));
		route.add(new LatLonPoint(38.93846459656021,-77.08541706204414));
		route.add(new LatLonPoint(38.93848754563178,-77.08540700376034));
		route.add(new LatLonPoint(38.93850423586099,-77.08539694547653));
		route.add(new LatLonPoint(38.93852301236414,-77.08537817001343));
		route.add(new LatLonPoint(38.93855587123274,-77.08535134792328));
		route.add(new LatLonPoint(38.93858507910314,-77.08532720804214));
		route.add(new LatLonPoint(38.938612722255094,-77.08530306816101));
		route.add(new LatLonPoint(38.93863671441601,-77.08528563380241));
		route.add(new LatLonPoint(38.9386539261786,-77.08526618778706));
		route.add(new LatLonPoint(38.93867426734719,-77.08525076508522));
		route.add(new LatLonPoint(38.93869930262361,-77.08523198962212));
		route.add(new LatLonPoint(38.93873007513876,-77.08520650863647));
		route.add(new LatLonPoint(38.93876449861448,-77.08517834544182));
		route.add(new LatLonPoint(38.93879266326397,-77.08515219390392));
		route.add(new LatLonPoint(38.93881978476775,-77.08513006567955));
		route.add(new LatLonPoint(38.93885107879766,-77.0851032435894));
		route.add(new LatLonPoint(38.93887194147661,-77.08508312702179));
		route.add(new LatLonPoint(38.93890792958336,-77.0850569754839));
		route.add(new LatLonPoint(38.93893452947661,-77.08503283560276));
		route.add(new LatLonPoint(38.93897051755158,-77.08500064909458));
		route.add(new LatLonPoint(38.939005462476494,-77.08497181534767));
		route.add(new LatLonPoint(38.939040407384134,-77.08494432270527));
		route.add(new LatLonPoint(38.93907743853619,-77.08490945398808));
		route.add(new LatLonPoint(38.939126465665446,-77.0848685503006));
		route.add(new LatLonPoint(38.93916662616097,-77.08483301103115));
		route.add(new LatLonPoint(38.93920782976261,-77.08479546010494));
		route.add(new LatLonPoint(38.93926050775008,-77.08475321531296));
		route.add(new LatLonPoint(38.939299103478454,-77.08472236990929));
		route.add(new LatLonPoint(38.93933822074927,-77.0846888422966));
		route.add(new LatLonPoint(38.939392984892145,-77.08464123308659));
		route.add(new LatLonPoint(38.939438360864216,-77.08460368216038));
		route.add(new LatLonPoint(38.93951503054415,-77.08453796803951));
		route.add(new LatLonPoint(38.939602652934006,-77.08446219563484));
		route.add(new LatLonPoint(38.93968975365468,-77.08438709378242));
		route.add(new LatLonPoint(38.93977841894908,-77.08430998027325));
		route.add(new LatLonPoint(38.939875950644876,-77.08422884345055));
		route.add(new LatLonPoint(38.93995105517479,-77.08416312932968));
		route.add(new LatLonPoint(38.94004337105049,-77.08408534526825));
		route.add(new LatLonPoint(38.94012682032623,-77.08401426672935));
		route.add(new LatLonPoint(38.94019618746195,-77.08395056426525));
		route.add(new LatLonPoint(38.940232174896586,-77.08392307162285));
		route.add(new LatLonPoint(38.94026764075636,-77.08389155566692));
		route.add(new LatLonPoint(38.940321882625184,-77.08384729921818));
		route.add(new LatLonPoint(38.94035839155199,-77.08381310105324));
		route.add(new LatLonPoint(38.940440797346284,-77.08374537527561));
		route.add(new LatLonPoint(38.94052737548269,-77.08366893231869));
		route.add(new LatLonPoint(38.94060821641823,-77.08360120654106));
		route.add(new LatLonPoint(38.940658285596584,-77.08355695009232));
		route.add(new LatLonPoint(38.94075007899842,-77.08347782492638));
		route.add(new LatLonPoint(38.940826225707504,-77.08341747522354));
		route.add(new LatLonPoint(38.94086377747914,-77.08338260650635));
		route.add(new LatLonPoint(38.94093053613514,-77.08332695066929));
		route.add(new LatLonPoint(38.94100772575282,-77.08326324820518));
		route.add(new LatLonPoint(38.94109638939913,-77.08318814635277));
		route.add(new LatLonPoint(38.94118661758421,-77.0831137150526));
		route.add(new LatLonPoint(38.94127893185126,-77.08303391933441));
		route.add(new LatLonPoint(38.941362379672846,-77.08296284079552));
		route.add(new LatLonPoint(38.94145156442361,-77.08288840949535));
		route.add(new LatLonPoint(38.941497460625875,-77.08284884691238));
		route.add(new LatLonPoint(38.94152979656874,-77.08281934261322));
		route.add(new LatLonPoint(38.941565783326496,-77.08278581500053));
		route.add(new LatLonPoint(38.941605420893644,-77.08275228738785));
		route.add(new LatLonPoint(38.94166487720282,-77.08270199596882));
		route.add(new LatLonPoint(38.94174832457017,-77.08263024687767));
		route.add(new LatLonPoint(38.94184115965094,-77.08255112171173));
		route.add(new LatLonPoint(38.94193868850935,-77.08246797323227));
		route.add(new LatLonPoint(38.942024743273045,-77.0823935419321));
		route.add(new LatLonPoint(38.94209358700877,-77.082329839468));
		route.add(new LatLonPoint(38.94217807695673,-77.08226010203362));
		route.add(new LatLonPoint(38.942259959094145,-77.08218835294247));
		route.add(new LatLonPoint(38.9423449703852,-77.08211794495583));
		route.add(new LatLonPoint(38.942445627794314,-77.08203211426735));
		route.add(new LatLonPoint(38.942511341880696,-77.08197645843029));
		route.add(new LatLonPoint(38.94253689734228,-77.08195298910141));
		route.add(new LatLonPoint(38.94258122822317,-77.08191476762295));
		route.add(new LatLonPoint(38.942624515997785,-77.0818792283535));
		route.add(new LatLonPoint(38.94268240683576,-77.08182826638222));
		route.add(new LatLonPoint(38.94273873301112,-77.0817806571722));
		route.add(new LatLonPoint(38.9428273944928,-77.08170488476753));
		route.add(new LatLonPoint(38.9429170989379,-77.08163045346737));
		route.add(new LatLonPoint(38.94294786962257,-77.08160296082497));
		route.add(new LatLonPoint(38.94300367405054,-77.08155401051044));
		route.add(new LatLonPoint(38.943045396958645,-77.08152115345001));
		route.add(new LatLonPoint(38.94308920598572,-77.08148159086704));
		route.add(new LatLonPoint(38.94314709644426,-77.08143331110477));
		route.add(new LatLonPoint(38.94317682395868,-77.08140715956688));
		route.add(new LatLonPoint(38.94326235568496,-77.08133339881897));
		route.add(new LatLonPoint(38.94332285367296,-77.0812837779522));
		route.add(new LatLonPoint(38.94336979173151,-77.08124421536922));
		route.add(new LatLonPoint(38.94341672975903,-77.08120532333851));
		route.add(new LatLonPoint(38.9434657538879,-77.08116374909878));
		route.add(new LatLonPoint(38.94353407469181,-77.0811040699482));
		route.add(new LatLonPoint(38.94356223744676,-77.08107858896255));
		route.add(new LatLonPoint(38.94361699832718,-77.08103433251381));
		route.add(new LatLonPoint(38.94358205567504,-77.08103366196156));
		route.add(new LatLonPoint(38.943583098739545,-77.08103366196156));
		route.add(new LatLonPoint(38.943659242406035,-77.08099745213985));
		route.add(new LatLonPoint(38.943697314208606,-77.08096593618393));
		route.add(new LatLonPoint(38.94374425201926,-77.08092503249645));
		route.add(new LatLonPoint(38.9438010988817,-77.08087675273418));
		route.add(new LatLonPoint(38.943871505482946,-77.08082109689713));
		route.add(new LatLonPoint(38.94395755790065,-77.08074666559696));
		route.add(new LatLonPoint(38.94404361021392,-77.08067290484905));
		route.add(new LatLonPoint(38.94413331312016,-77.08059713244438));
		route.add(new LatLonPoint(38.94422145133032,-77.08052471280098));
		route.add(new LatLonPoint(38.944274125592955,-77.08047978579998));
		route.add(new LatLonPoint(38.94432679981643,-77.08043351769447));
		route.add(new LatLonPoint(38.944408679472275,-77.08036713302135));
		route.add(new LatLonPoint(38.944478042418844,-77.08031415939331));
		route.add(new LatLonPoint(38.944554706649264,-77.08025380969048));
		route.add(new LatLonPoint(38.94461207438649,-77.08020687103271));
		route.add(new LatLonPoint(38.94470125504947,-77.08013512194157));
		route.add(new LatLonPoint(38.94475340743199,-77.08009354770184));
		route.add(new LatLonPoint(38.94481911937931,-77.0800419151783));
		route.add(new LatLonPoint(38.944850932284325,-77.08001643419266));
		route.add(new LatLonPoint(38.94494219873583,-77.07993932068348));
		route.add(new LatLonPoint(38.94499017876608,-77.07989774644375));
		route.add(new LatLonPoint(38.94505328288688,-77.07984745502472));
		route.add(new LatLonPoint(38.9451325540995,-77.07977905869484));
		route.add(new LatLonPoint(38.94522538474897,-77.07969658076763));
		route.add(new LatLonPoint(38.94522903538999,-77.0796999335289));
		route.add(new LatLonPoint(38.94532186591313,-77.07962214946747));
		route.add(new LatLonPoint(38.945403222900865,-77.07955308258533));
		route.add(new LatLonPoint(38.94548927345938,-77.07948133349419));
		route.add(new LatLonPoint(38.94557115177262,-77.07941092550755));
		route.add(new LatLonPoint(38.945656159093296,-77.07934185862541));
		route.add(new LatLonPoint(38.94573699418099,-77.07927346229553));
		route.add(new LatLonPoint(38.94581730766072,-77.0792043954134));
		route.add(new LatLonPoint(38.945833996164566,-77.07918629050255));
		route.add(new LatLonPoint(38.94586215800593,-77.07913197577));
		route.add(new LatLonPoint(38.94588145407592,-77.07908235490322));
		route.add(new LatLonPoint(38.94589814256468,-77.07904949784279));
		route.add(new LatLonPoint(38.94592630438053,-77.07898646593094));
		route.add(new LatLonPoint(38.94594977255188,-77.07893684506416));
		route.add(new LatLonPoint(38.9459701116274,-77.07889460027218));
		route.add(new LatLonPoint(38.94598158494951,-77.07886844873428));
		route.add(new LatLonPoint(38.94599097221164,-77.07884430885315));
		route.add(new LatLonPoint(38.946008703703406,-77.07880608737469));
		route.add(new LatLonPoint(38.94602539216221,-77.07876116037369));
		route.add(new LatLonPoint(38.94604468818779,-77.07870483398438));
		route.add(new LatLonPoint(38.946059812096046,-77.0786652714014));
		route.add(new LatLonPoint(38.946079629626155,-77.07863107323647));
		route.add(new LatLonPoint(38.94609840412325,-77.07860291004181));
		route.add(new LatLonPoint(38.946118221642536,-77.0785827934742));
		route.add(new LatLonPoint(38.946141689750355,-77.0785566419363));
		route.add(new LatLonPoint(38.946168286929776,-77.07853317260742));
		route.add(new LatLonPoint(38.946191755021005,-77.0785117149353));
		route.add(new LatLonPoint(38.9462251318485,-77.07847952842712));
		route.add(new LatLonPoint(38.94625329353445,-77.07845538854599));
		route.add(new LatLonPoint(38.9462871918453,-77.07843594253063));
		route.add(new LatLonPoint(38.94631274594584,-77.07841917872429));
		route.add(new LatLonPoint(38.94633412794125,-77.07840509712696));
		route.add(new LatLonPoint(38.94636124656032,-77.07840710878372));
		route.add(new LatLonPoint(38.94640192446945,-77.07841046154499));
		route.add(new LatLonPoint(38.94642956457387,-77.07841783761978));
		route.add(new LatLonPoint(38.946455118623085,-77.07842588424683));
		route.add(new LatLonPoint(38.946479629641246,-77.07843862473965));
		route.add(new LatLonPoint(38.946503097629396,-77.07845136523247));
		route.add(new LatLonPoint(38.94652447956738,-77.0784654468298));
		route.add(new LatLonPoint(38.946544296967595,-77.07847885787487));
		route.add(new LatLonPoint(38.94656202832094,-77.07849763333797));
		route.add(new LatLonPoint(38.94658236722083,-77.07851506769657));
		route.add(new LatLonPoint(38.94659749101439,-77.07853384315968));
		route.add(new LatLonPoint(38.946620958963535,-77.0785204321146));
		route.add(new LatLonPoint(38.94665277105997,-77.07849629223347));
		route.add(new LatLonPoint(38.94668093257603,-77.07847617566586));
		route.add(new LatLonPoint(38.9467007499325,-77.07846142351627));
		route.add(new LatLonPoint(38.94673360501127,-77.0784654468298));
		route.add(new LatLonPoint(38.94677584723301,-77.07847014069557));
		route.add(new LatLonPoint(38.946820696971756,-77.07847751677036));
		route.add(new LatLonPoint(38.94686971874676,-77.07848288118839));
		route.add(new LatLonPoint(38.9469051812863,-77.07848757505417));
		route.add(new LatLonPoint(38.94698132138471,-77.07849629223347));
		route.add(new LatLonPoint(38.947020955924145,-77.07850232720375));
		route.add(new LatLonPoint(38.947072063587015,-77.07850702106953));
		route.add(new LatLonPoint(38.9471137841008,-77.07851238548756));
		route.add(new LatLonPoint(38.94720139709983,-77.07852311432362));
		route.add(new LatLonPoint(38.947258241190106,-77.07853250205517));
		route.add(new LatLonPoint(38.94730517664315,-77.0785378664732));
		route.add(new LatLonPoint(38.94734011746021,-77.07854188978672));
		route.add(new LatLonPoint(38.94736827870322,-77.07854188978672));
		route.add(new LatLonPoint(38.94742668717161,-77.07854054868221));
		route.add(new LatLonPoint(38.94746423544727,-77.0785392075777));
		route.add(new LatLonPoint(38.94753046638506,-77.07853652536869));
		route.add(new LatLonPoint(38.94757583714924,-77.07853451371193));
		route.add(new LatLonPoint(38.947629030421986,-77.07853116095066));
		route.add(new LatLonPoint(38.947715599780544,-77.07852780818939));
		route.add(new LatLonPoint(38.947771400455636,-77.07852646708488));
		route.add(new LatLonPoint(38.947837109605494,-77.07852445542812));
		route.add(new LatLonPoint(38.9479054261967,-77.07852110266685));
		route.add(new LatLonPoint(38.947928893712856,-77.07852177321911));
		route.add(new LatLonPoint(38.94796644172253,-77.07852110266685));
		route.add(new LatLonPoint(38.94801546270519,-77.07852244377136));
		route.add(new LatLonPoint(38.94805718266375,-77.07852311432362));
		route.add(new LatLonPoint(38.948088994115665,-77.0785204321146));
		route.add(new LatLonPoint(38.9481453159955,-77.07852311432362));
		route.add(new LatLonPoint(38.94820320232535,-77.07852579653263));
		route.add(new LatLonPoint(38.94824909415688,-77.07852512598038));
		route.add(new LatLonPoint(38.94829289996834,-77.07852713763714));
		route.add(new LatLonPoint(38.94834713569742,-77.07852713763714));
		route.add(new LatLonPoint(38.948409193836504,-77.07852981984615));
		route.add(new LatLonPoint(38.94846551546192,-77.07852847874165));
		route.add(new LatLonPoint(38.948516100587334,-77.0785291492939));
		route.add(new LatLonPoint(38.948616227739464,-77.07853250205517));
		route.add(new LatLonPoint(38.9487116612997,-77.07853317260742));
		route.add(new LatLonPoint(38.94878258451805,-77.07853250205517));
		route.add(new LatLonPoint(38.94885559363931,-77.07853585481644));
		route.add(new LatLonPoint(38.94894216149992,-77.07853585481644));
		route.add(new LatLonPoint(38.94901360597995,-77.0785378664732));
		route.add(new LatLonPoint(38.949105910055565,-77.07853652536869));
		route.add(new LatLonPoint(38.949186741209495,-77.07854054868221));
		route.add(new LatLonPoint(38.94926705078083,-77.07854121923447));
		route.add(new LatLonPoint(38.94936509091341,-77.07854457199574));
		route.add(new LatLonPoint(38.94949494173135,-77.07854457199574));
		route.add(new LatLonPoint(38.94960966916369,-77.07854725420475));
		route.add(new LatLonPoint(38.949663382397745,-77.07855932414532));
		route.add(new LatLonPoint(38.94968006999615,-77.0785740762949));
		route.add(new LatLonPoint(38.949688935281216,-77.07859016954899));
		route.add(new LatLonPoint(38.94969467164155,-77.07861095666885));
		route.add(new LatLonPoint(38.94969571461609,-77.07862436771393));
		route.add(new LatLonPoint(38.949693107179684,-77.07864314317703));
		route.add(new LatLonPoint(38.949693107179684,-77.07866728305817));
		route.add(new LatLonPoint(38.949688935281216,-77.07869209349155));
		route.add(new LatLonPoint(38.94968424189514,-77.07871355116367));
		route.add(new LatLonPoint(38.94968006999615,-77.07872964441776));
		route.add(new LatLonPoint(38.94967850553397,-77.07874238491058));
		route.add(new LatLonPoint(38.9496696402476,-77.07874171435833));
		route.add(new LatLonPoint(38.94963887248046,-77.07874305546284));
		route.add(new LatLonPoint(38.949602889820575,-77.07873970270157));
		route.add(new LatLonPoint(38.949545526122144,-77.07873903214931));
		route.add(new LatLonPoint(38.949491812798755,-77.07874171435833));
		route.add(new LatLonPoint(38.94942662667206,-77.07874104380608));
		route.add(new LatLonPoint(38.94937395623787,-77.07873970270157));
		route.add(new LatLonPoint(38.94931294192361,-77.07874104380608));
		route.add(new LatLonPoint(38.94926705078083,-77.07873836159706));
		route.add(new LatLonPoint(38.94922220258988,-77.07873903214931));
		route.add(new LatLonPoint(38.949176311388385,-77.07873836159706));
		route.add(new LatLonPoint(38.94910695303878,-77.07873836159706));
		route.add(new LatLonPoint(38.948999525686666,-77.07873769104481));
		route.add(new LatLonPoint(38.9488931411581,-77.07873500883579));
		route.add(new LatLonPoint(38.948795621866644,-77.07873500883579));
		route.add(new LatLonPoint(38.948611012787126,-77.07873567938805));
		route.add(new LatLonPoint(38.94849993421098,-77.07873433828354));
		route.add(new LatLonPoint(38.94839198444202,-77.07873299717903));
		route.add(new LatLonPoint(38.94828872798746,-77.07873232662678));
		route.add(new LatLonPoint(38.94819172936283,-77.07873165607452));
		route.add(new LatLonPoint(38.948124456045214,-77.07873098552227));
		route.add(new LatLonPoint(38.94805509666641,-77.07873366773129));
		route.add(new LatLonPoint(38.948021720700545,-77.07873165607452));
		route.add(new LatLonPoint(38.947990952218085,-77.07873165607452));
		route.add(new LatLonPoint(38.9479539257215,-77.07873232662678));
		route.add(new LatLonPoint(38.94792315720963,-77.07873098552227));
		route.add(new LatLonPoint(38.947912727202564,-77.07873098552227));
		route.add(new LatLonPoint(38.94791064120097,-77.07863442599773));
		route.add(new LatLonPoint(38.94790959820015,-77.07853585481644));
		route.add(new LatLonPoint(38.94790907669973,-77.07852445542812));
		route.add(new LatLonPoint(38.94789968969158,-77.07852110266685));
		route.add(new LatLonPoint(38.94783137309483,-77.07852311432362));
		route.add(new LatLonPoint(38.94776618544114,-77.07852445542812));
		route.add(new LatLonPoint(38.947711427765704,-77.07852579653263));
		route.add(new LatLonPoint(38.94762642290957,-77.07853250205517));
		route.add(new LatLonPoint(38.94757062212037,-77.07853317260742));
		route.add(new LatLonPoint(38.94752733736577,-77.07853585481644));
		route.add(new LatLonPoint(38.947459541913894,-77.07853853702545));
		route.add(new LatLonPoint(38.94742355814771,-77.0785392075777));
		route.add(new LatLonPoint(38.94736410666792,-77.07854256033897));
		route.add(new LatLonPoint(38.94733542391862,-77.0785392075777));
		route.add(new LatLonPoint(38.94730048309924,-77.07853585481644));
		route.add(new LatLonPoint(38.9472525046326,-77.0785304903984));
		route.add(new LatLonPoint(38.947196703549054,-77.07852177321911));
		route.add(new LatLonPoint(38.947107526025306,-77.0785103738308));
		route.add(new LatLonPoint(38.94706580550783,-77.07850635051727));
		route.add(new LatLonPoint(38.94701678386841,-77.07850031554699));
		route.add(new LatLonPoint(38.94697662781938,-77.0784942805767));
		route.add(new LatLonPoint(38.94689892319235,-77.07848489284515));
		route.add(new LatLonPoint(38.946863982157836,-77.07848221063614));
		route.add(new LatLonPoint(38.94681287434495,-77.07847349345684));
		route.add(new LatLonPoint(38.94676802460125,-77.07846947014332));
		route.add(new LatLonPoint(38.946727346902186,-77.07846410572529));
		route.add(new LatLonPoint(38.94669762087658,-77.07846075296402));
		route.add(new LatLonPoint(38.946676238990804,-77.0784755051136));
		route.add(new LatLonPoint(38.946672588424285,-77.07847684621811));
		route.add(new LatLonPoint(38.94664964200194,-77.07849830389023));
		route.add(new LatLonPoint(38.94661782990409,-77.07852177321911));
		route.add(new LatLonPoint(38.94659644799425,-77.0785392075777));
		route.add(new LatLonPoint(38.946602184604856,-77.07855999469757));
		route.add(new LatLonPoint(38.946605835174985,-77.0786015689373));
		route.add(new LatLonPoint(38.946614179334595,-77.07865186035633));
		route.add(new LatLonPoint(38.94661730839417,-77.07869946956635));
		route.add(new LatLonPoint(38.94661730839417,-77.07873366773129));
		route.add(new LatLonPoint(38.94661313631469,-77.07877859473228));
		route.add(new LatLonPoint(38.946609485744915,-77.07881078124046));
		route.add(new LatLonPoint(38.94660479215496,-77.07883022725582));
		route.add(new LatLonPoint(38.94659071138319,-77.0788711309433));
		route.add(new LatLonPoint(38.94657923815971,-77.078907340765));
		route.add(new LatLonPoint(38.9465740230575,-77.07892410457134));
		route.add(new LatLonPoint(38.946566721913754,-77.07893282175064));
		route.add(new LatLonPoint(38.94655681321749,-77.0789422094822));
		route.add(new LatLonPoint(38.94651926446116,-77.07898981869221));
		route.add(new LatLonPoint(38.946496839499986,-77.07901529967785));
		route.add(new LatLonPoint(38.946455118623085,-77.07905352115631));
		route.add(new LatLonPoint(38.946424870971974,-77.07907363772392));
		route.add(new LatLonPoint(38.94638523609929,-77.07909241318703));
		route.add(new LatLonPoint(38.94634038608504,-77.07911923527718));
		route.add(new LatLonPoint(38.94632578374869,-77.0791232585907));
		route.add(new LatLonPoint(38.946302315701836,-77.07912795245647));
		route.add(new LatLonPoint(38.9462366051293,-77.07914538681507));
		route.add(new LatLonPoint(38.946205835872036,-77.0791494101286));
		route.add(new LatLonPoint(38.946177152654045,-77.07915343344212));
		route.add(new LatLonPoint(38.94614586185759,-77.07915410399437));
		route.add(new LatLonPoint(38.94612865191364,-77.07915008068085));
		route.add(new LatLonPoint(38.94611092045187,-77.07915812730789));
		route.add(new LatLonPoint(38.94606867783388,-77.07916215062141));
		route.add(new LatLonPoint(38.94600713916019,-77.07917153835297));
		route.add(new LatLonPoint(38.945956552244375,-77.0791782438755));
		route.add(new LatLonPoint(38.945912223474004,-77.07918629050255));
		route.add(new LatLonPoint(38.945864244067806,-77.07918897271156));
		route.add(new LatLonPoint(38.94583921132122,-77.07919500768185));
		route.add(new LatLonPoint(38.945828781007556,-77.07919500768185));
		route.add(new LatLonPoint(38.945812092502464,-77.07920640707016));
		route.add(new LatLonPoint(38.94573334356613,-77.07927614450455));
		route.add(new LatLonPoint(38.94565146544021,-77.07934252917767));
		route.add(new LatLonPoint(38.94556697963154,-77.0794129371643));
		route.add(new LatLonPoint(38.945487708904686,-77.07948133349419));
		route.add(new LatLonPoint(38.94540009378766,-77.07955442368984));
		route.add(new LatLonPoint(38.94531977983527,-77.07962214946747));
		route.add(new LatLonPoint(38.94522590626913,-77.07969725131989));
		route.add(new LatLonPoint(38.945128903453494,-77.07978039979935));
		route.add(new LatLonPoint(38.945049632236774,-77.07984879612923));
		route.add(new LatLonPoint(38.94498704963466,-77.07989975810051));
		route.add(new LatLonPoint(38.9449369835132,-77.07993730902672));
		route.add(new LatLonPoint(38.944844152486084,-77.08001643419266));
		route.add(new LatLonPoint(38.94481286110125,-77.08004057407379));
		route.add(new LatLonPoint(38.94474402000597,-77.08009421825409));
		route.add(new LatLonPoint(38.94469395371286,-77.0801331102848));
		route.add(new LatLonPoint(38.94460633761488,-77.08020821213722));
		route.add(new LatLonPoint(38.94454688377242,-77.08025380969048));
		route.add(new LatLonPoint(38.94446969800782,-77.08031415939331));
		route.add(new LatLonPoint(38.94439981352684,-77.08036109805107));
		route.add(new LatLonPoint(38.944321584548526,-77.08042949438095));
		route.add(new LatLonPoint(38.944266302685136,-77.0804750919342));
		route.add(new LatLonPoint(38.94421623605466,-77.08052203059196));
		route.add(new LatLonPoint(38.944124447140304,-77.08059713244438));
		route.add(new LatLonPoint(38.94403578728066,-77.08067089319229));
		route.add(new LatLonPoint(38.94395025648745,-77.08074063062668));
		route.add(new LatLonPoint(38.943863682530704,-77.0808157324791));
		route.add(new LatLonPoint(38.9437958835751,-77.08087608218193));
		route.add(new LatLonPoint(38.943741644363946,-77.08091899752617));
		route.add(new LatLonPoint(38.94369262042585,-77.08096861839294));
		route.add(new LatLonPoint(38.94365298402558,-77.08099812269211));
		route.add(new LatLonPoint(38.943610218410946,-77.0810329914093));
		route.add(new LatLonPoint(38.943555979057734,-77.08107993006706));
		route.add(new LatLonPoint(38.94352885936557,-77.08110004663467));
		route.add(new LatLonPoint(38.94345688782453,-77.08116173744202));
		route.add(new LatLonPoint(38.94340890675661,-77.08120465278625));
		route.add(new LatLonPoint(38.943360925656165,-77.08124086260796));
		route.add(new LatLonPoint(38.943316073728596,-77.08128243684769));
		route.add(new LatLonPoint(38.94325453266549,-77.08133742213249));
		route.add(new LatLonPoint(38.94316900092977,-77.08140447735786));
		route.add(new LatLonPoint(38.943138751876575,-77.08143532276154));
		route.add(new LatLonPoint(38.94308033987528,-77.0814836025238));
		route.add(new LatLonPoint(38.943039660060236,-77.08151713013649));
		route.add(new LatLonPoint(38.94299585100252,-77.08155333995819));
		route.add(new LatLonPoint(38.94294265425323,-77.08159893751144));
		route.add(new LatLonPoint(38.94291136202911,-77.0816257596016));
		route.add(new LatLonPoint(38.94282165757676,-77.08170354366302));
		route.add(new LatLonPoint(38.94273403916488,-77.08178132772446));
		route.add(new LatLonPoint(38.94267562683014,-77.08182692527771));
		route.add(new LatLonPoint(38.9426161713686,-77.081877887249));
		route.add(new LatLonPoint(38.94256923281108,-77.08191275596619));
		route.add(new LatLonPoint(38.94252959578277,-77.08194896578789));
		route.add(new LatLonPoint(38.94250143261761,-77.08197712898254));
		route.add(new LatLonPoint(38.94243780468475,-77.08202943205833));
		route.add(new LatLonPoint(38.94233871188872,-77.0821139216423));
		route.add(new LatLonPoint(38.94225422213218,-77.08218768239021));
		route.add(new LatLonPoint(38.94217286153075,-77.08226412534714));
		route.add(new LatLonPoint(38.942088371576574,-77.0823284983635));
		route.add(new LatLonPoint(38.942016398573244,-77.08239287137985));
		route.add(new LatLonPoint(38.941930865343835,-77.08246394991875));
		route.add(new LatLonPoint(38.94183281492954,-77.08254843950272));
		route.add(new LatLonPoint(38.941739979837855,-77.0826356112957));
		route.add(new LatLonPoint(38.94166383411009,-77.08270132541656));
		route.add(new LatLonPoint(38.94159811923821,-77.08275362849236));
		route.add(new LatLonPoint(38.94156161094973,-77.08278447389603));
		route.add(new LatLonPoint(38.94152197335811,-77.08281800150871));
		route.add(new LatLonPoint(38.94149068050696,-77.08284348249435));
		route.add(new LatLonPoint(38.941449999779806,-77.08288103342056));
		route.add(new LatLonPoint(38.9413592503813,-77.08295747637749));
		route.add(new LatLonPoint(38.941270587063684,-77.08303660154343));
		route.add(new LatLonPoint(38.9411808805354,-77.08311036229134));
		route.add(new LatLonPoint(38.941089087691275,-77.08318948745728));
		route.add(new LatLonPoint(38.94100042403583,-77.08326324820518));
		route.add(new LatLonPoint(38.9409253206174,-77.08332628011703));
		route.add(new LatLonPoint(38.94085856195648,-77.08337992429733));
		route.add(new LatLonPoint(38.94082205328721,-77.08341479301453));
		route.add(new LatLonPoint(38.9407427772549,-77.08347514271736));
		route.add(new LatLonPoint(38.94065098384362,-77.0835542678833));
		route.add(new LatLonPoint(38.940597785334944,-77.08359986543655));
		route.add(new LatLonPoint(38.94051433661349,-77.08366021513939));
		route.add(new LatLonPoint(38.940430887793816,-77.08374068140984));
		route.add(new LatLonPoint(38.94035265443618,-77.08381444215775));
		route.add(new LatLonPoint(38.94031405928128,-77.08384796977043));
		route.add(new LatLonPoint(38.94026190363318,-77.08389088511467));
		route.add(new LatLonPoint(38.94022435154278,-77.08391904830933));
		route.add(new LatLonPoint(38.940190971890196,-77.08395391702652));
		route.add(new LatLonPoint(38.94012108319167,-77.08401829004288));
		route.add(new LatLonPoint(38.94003450455918,-77.08408936858177));
		route.add(new LatLonPoint(38.93994375334898,-77.08416312932968));
		route.add(new LatLonPoint(38.93987073504956,-77.08422884345055));
		route.add(new LatLonPoint(38.93976746618343,-77.0843106508255));
		route.add(new LatLonPoint(38.939685059606596,-77.08438977599144));
		route.add(new LatLonPoint(38.93959535107232,-77.08446353673935));
		route.add(new LatLonPoint(38.93950668554902,-77.0845440030098));
		route.add(new LatLonPoint(38.93943053742284,-77.08460569381714));
		route.add(new LatLonPoint(38.93938568300888,-77.08463922142982));
		route.add(new LatLonPoint(38.9393345698049,-77.08469152450562));
		route.add(new LatLonPoint(38.93929388784069,-77.08471834659576));
		route.add(new LatLonPoint(38.93925529210949,-77.08474785089493));
		route.add(new LatLonPoint(38.939206265069295,-77.0847961306572));
		route.add(new LatLonPoint(38.939162453643014,-77.08483099937439));
		route.add(new LatLonPoint(38.93912281471018,-77.08486452698708));
		route.add(new LatLonPoint(38.939069615054954,-77.0849061012268));
		route.add(new LatLonPoint(38.93903519172739,-77.08493962883949));
		route.add(new LatLonPoint(38.939004940910564,-77.08496779203415));
		route.add(new LatLonPoint(38.93896947441924,-77.0849946141243));
		route.add(new LatLonPoint(38.938937137308734,-77.08501875400543));
		route.add(new LatLonPoint(38.93890584331679,-77.08504557609558));
		route.add(new LatLonPoint(38.938868290508246,-77.08507776260376));
		route.add(new LatLonPoint(38.93885055723061,-77.08508983254433));
		route.add(new LatLonPoint(38.9388223926041,-77.08511799573898));
		route.add(new LatLonPoint(38.938795271101334,-77.08513274788857));
		route.add(new LatLonPoint(38.938705561441324,-77.08521589636803));
		route.add(new LatLonPoint(38.93863149872952,-77.0852829515934));
		route.add(new LatLonPoint(38.93860229087825,-77.08530843257904));
		route.add(new LatLonPoint(38.93857412615314,-77.0853365957737));
		route.add(new LatLonPoint(38.93854387513963,-77.0853553712368));
		route.add(new LatLonPoint(38.93850840841767,-77.08538621664047));
		route.add(new LatLonPoint(38.93849589074688,-77.08539292216301));
		route.add(new LatLonPoint(38.93846459656021,-77.08545461297035));
		route.add(new LatLonPoint(38.93845207888165,-77.08548814058304));
		route.add(new LatLonPoint(38.938441647481206,-77.08548545837402));
		route.add(new LatLonPoint(38.938408266989384,-77.0855350792408));
		route.add(new LatLonPoint(38.93838323161022,-77.08557799458504));
		route.add(new LatLonPoint(38.93834254910023,-77.0856611430645));
		route.add(new LatLonPoint(38.93831647055589,-77.0857147872448));
		route.add(new LatLonPoint(38.93829873714027,-77.08574697375298));
		route.add(new LatLonPoint(38.938294564571244,-77.08580732345581));
		route.add(new LatLonPoint(38.93829560771351,-77.08586767315865));
		route.add(new LatLonPoint(38.938292478286634,-77.08594545722008));
		route.add(new LatLonPoint(38.938286219432456,-77.08599507808685));
		route.add(new LatLonPoint(38.9382893488596,-77.08603397011757));
		route.add(new LatLonPoint(38.938291435144286,-77.08607017993927));
		route.add(new LatLonPoint(38.938292478286634,-77.08611980080605));
		route.add(new LatLonPoint(38.93829560771351,-77.08618149161339));
		route.add(new LatLonPoint(38.93830395285121,-77.08624586462975));
		route.add(new LatLonPoint(38.938308125419674,-77.08627805113792));
		route.add(new LatLonPoint(38.93832481569112,-77.08634778857231));
		route.add(new LatLonPoint(38.93834672166643,-77.08641618490219));
		route.add(new LatLonPoint(38.93836758449374,-77.08646982908249));
		route.add(new LatLonPoint(38.93838531789216,-77.08651408553123));
		route.add(new LatLonPoint(38.938404094426794,-77.08653956651688));
		route.add(new LatLonPoint(38.93842495723727,-77.08660662174225));
		route.add(new LatLonPoint(38.93848545935284,-77.08669915795326));
		route.add(new LatLonPoint(38.938559522217176,-77.08679974079132));
		route.add(new LatLonPoint(38.93862523990527,-77.08688959479332));
		route.add(new LatLonPoint(38.93869408694176,-77.08697944879532));
		route.add(new LatLonPoint(38.93876084764057,-77.08707332611084));
		route.add(new LatLonPoint(38.93883595335159,-77.08717122673988));
		route.add(new LatLonPoint(38.93890062765012,-77.0872637629509));
		route.add(new LatLonPoint(38.93899972525118,-77.08739653229713));
		route.add(new LatLonPoint(38.93905709748324,-77.08748236298561));
		route.add(new LatLonPoint(38.939125944100425,-77.0875708758831));
		route.add(new LatLonPoint(38.93920209255368,-77.08767145872116));
		route.add(new LatLonPoint(38.93926989590216,-77.08776265382767));
		route.add(new LatLonPoint(38.93934395794716,-77.08785519003868));
		route.add(new LatLonPoint(38.93941384741166,-77.08796381950378));
		route.add(new LatLonPoint(38.93949103868045,-77.0880576968193));
		route.add(new LatLonPoint(38.939554669257745,-77.08815693855286));
		route.add(new LatLonPoint(38.939694447702465,-77.08834737539291));
		route.add(new LatLonPoint(38.939762250580124,-77.08843857049942));
		route.add(new LatLonPoint(38.939832139632344,-77.08853244781494));
		route.add(new LatLonPoint(38.93990724420867,-77.08863571286201));
		route.add(new LatLonPoint(38.939980262470485,-77.08873227238655));
		route.add(new LatLonPoint(38.94005119442427,-77.08883419632912));
		route.add(new LatLonPoint(38.94010335022736,-77.08890527486801));
		route.add(new LatLonPoint(38.94014298861206,-77.08895489573479));
		route.add(new LatLonPoint(38.94019410123329,-77.08902060985565));
		route.add(new LatLonPoint(38.94026398985983,-77.08911582827568));
		route.add(new LatLonPoint(38.94033283530522,-77.08921238780022));
		route.add(new LatLonPoint(38.94040063757244,-77.08931431174278));
		route.add(new LatLonPoint(38.94047887087712,-77.08941087126732));
		route.add(new LatLonPoint(38.94054771611384,-77.08951011300087));
		route.add(new LatLonPoint(38.94062699236426,-77.08961337804794));
		route.add(new LatLonPoint(38.940694794350186,-77.08970859646797));
		route.add(new LatLonPoint(38.940769898012775,-77.08980783820152));
		route.add(new LatLonPoint(38.940840829176615,-77.08990171551704));
		route.add(new LatLonPoint(38.94091176026949,-77.0900009572506));
		route.add(new LatLonPoint(38.940981648188675,-77.09010422229767));
		route.add(new LatLonPoint(38.941052579140695,-77.09019541740417));
		route.add(new LatLonPoint(38.941121423820384,-77.09029197692871));
		route.add(new LatLonPoint(38.941194440831836,-77.09039524197578));
		route.add(new LatLonPoint(38.941262242275165,-77.09049448370934));
		route.add(new LatLonPoint(38.94133838843419,-77.09060043096542));
		route.add(new LatLonPoint(38.941389500193715,-77.09067419171333));
		route.add(new LatLonPoint(38.94141244831865,-77.09071040153503));
		route.add(new LatLonPoint(38.94146564621608,-77.09078282117844));
		route.add(new LatLonPoint(38.94160333470646,-77.09095850586891));
		route.add(new LatLonPoint(38.941647144624596,-77.0910108089447));
		route.add(new LatLonPoint(38.94167948049919,-77.09105104207993));
		route.add(new LatLonPoint(38.94169616997707,-77.09107920527458));
		route.add(new LatLonPoint(38.941743109112586,-77.09113150835037));
		route.add(new LatLonPoint(38.941830728749046,-77.09124952554703));
		route.add(new LatLonPoint(38.94190896047582,-77.09136083722115));
		route.add(new LatLonPoint(38.94199449373164,-77.09146544337273));
		route.add(new LatLonPoint(38.94205082045353,-77.09154456853867));
		route.add(new LatLonPoint(38.94215199982304,-77.09166526794434));
		route.add(new LatLonPoint(38.942184857009906,-77.09171153604984));
		route.add(new LatLonPoint(38.94225787292622,-77.0918020606041));
		route.add(new LatLonPoint(38.942297510106464,-77.09185503423214));
		route.add(new LatLonPoint(38.94232932414297,-77.09189727902412));
		route.add(new LatLonPoint(38.942409641483124,-77.09201328456402));
		route.add(new LatLonPoint(38.942463360172844,-77.0920903980732));
		route.add(new LatLonPoint(38.94254159120157,-77.09220170974731));
		route.add(new LatLonPoint(38.94259635287031,-77.09227949380875));
		route.add(new LatLonPoint(38.94266415297302,-77.09237605333328));
		route.add(new LatLonPoint(38.94275333608633,-77.0925061404705));
		route.add(new LatLonPoint(38.94281852834961,-77.09259800612926));
		route.add(new LatLonPoint(38.942890500538695,-77.0926932245493));
		route.add(new LatLonPoint(38.94292752967995,-77.09274753928185));
		route.add(new LatLonPoint(38.94297655414711,-77.09280923008919));
		route.add(new LatLonPoint(38.9430088894154,-77.09285885095596));
		route.add(new LatLonPoint(38.9430380954515,-77.09289640188217));
		route.add(new LatLonPoint(38.943045396958645,-77.09291383624077));
		route.add(new LatLonPoint(38.94307147376372,-77.09293060004711));
		route.add(new LatLonPoint(38.94309077059334,-77.09294132888317));
		route.add(new LatLonPoint(38.94311528277469,-77.0929654687643));
		route.add(new LatLonPoint(38.943157005617124,-77.09302313625813));
		route.add(new LatLonPoint(38.943207594530605,-77.09309287369251));
		route.add(new LatLonPoint(38.943266006427066,-77.09317736327648));
		route.add(new LatLonPoint(38.94329416928853,-77.09321290254593));
		route.add(new LatLonPoint(38.94339691148454,-77.09335707128048));
		route.add(new LatLonPoint(38.943449064826545,-77.09343083202839));
		route.add(new LatLonPoint(38.94356484510871,-77.09359310567379));
		route.add(new LatLonPoint(38.94361699832718,-77.0936682075262));
		route.add(new LatLonPoint(38.94364881177162,-77.09370709955692));
		route.add(new LatLonPoint(38.94370409411651,-77.09378756582737));
		route.add(new LatLonPoint(38.94374581661242,-77.09384121000767));
		route.add(new LatLonPoint(38.94381883092119,-77.09394246339798));
		route.add(new LatLonPoint(38.94388767291483,-77.09403567016125));
		route.add(new LatLonPoint(38.943943998132674,-77.09411680698395));
		route.add(new LatLonPoint(38.94399562954303,-77.0941898971796));
		route.add(new LatLonPoint(38.94402431364366,-77.09423013031483));
		route.add(new LatLonPoint(38.94409732766562,-77.0943333953619));
		route.add(new LatLonPoint(38.94417190619608,-77.09443666040897));
		route.add(new LatLonPoint(38.94422145133032,-77.09450572729111));
		route.add(new LatLonPoint(38.944281948499906,-77.09459021687508));
		route.add(new LatLonPoint(38.94430646026944,-77.09462240338326));
		route.add(new LatLonPoint(38.94433827340447,-77.09467068314552));
		route.add(new LatLonPoint(38.944368000419416,-77.09470756351948));
		route.add(new LatLonPoint(38.944399292000625,-77.09475047886372));
		route.add(new LatLonPoint(38.94442119609923,-77.09477864205837));
		route.add(new LatLonPoint(38.94446813343063,-77.0948376506567));
		route.add(new LatLonPoint(38.94453280259188,-77.09492415189743));
		route.add(new LatLonPoint(38.944611552861836,-77.09502942860126));
		route.add(new LatLonPoint(38.94467674341645,-77.09511794149876));
		route.add(new LatLonPoint(38.94475653657372,-77.09522254765034));
		route.add(new LatLonPoint(38.94482850679538,-77.0953157544136));
		route.add(new LatLonPoint(38.94493333285712,-77.09545858204365));
		route.add(new LatLonPoint(38.944984963546986,-77.09552764892578));
		route.add(new LatLonPoint(38.94504493854353,-77.09560811519623));
		route.add(new LatLonPoint(38.9451184730353,-77.09570333361626));
		route.add(new LatLonPoint(38.94519252897119,-77.0958012342453));
		route.add(new LatLonPoint(38.945265020270135,-77.0958998054266));
		route.add(new LatLonPoint(38.945334382378846,-77.0959910005331));
		route.add(new LatLonPoint(38.945424605170594,-77.09612041711807));
		route.add(new LatLonPoint(38.945544032851295,-77.0962779968977));
		route.add(new LatLonPoint(38.9456405135818,-77.0964141190052));
		route.add(new LatLonPoint(38.94567128308446,-77.09645569324493));
		route.add(new LatLonPoint(38.94571039683974,-77.09650598466396));
		route.add(new LatLonPoint(38.945751075122345,-77.09656700491905));
		route.add(new LatLonPoint(38.94577923699661,-77.09660120308399));
		route.add(new LatLonPoint(38.94583816828992,-77.09668301045895));
		route.add(new LatLonPoint(38.94589084135134,-77.09675543010235));
		route.add(new LatLonPoint(38.94593464862013,-77.09675006568432));
		route.add(new LatLonPoint(38.94599045069711,-77.09674939513206));
		route.add(new LatLonPoint(38.94603530093275,-77.09674671292305));
		route.add(new LatLonPoint(38.946145340344174,-77.09675073623657));
		route.add(new LatLonPoint(38.94619227653406,-77.09675207734108));
		route.add(new LatLonPoint(38.946258508660236,-77.09675543010235));
		route.add(new LatLonPoint(38.94629344999321,-77.09675744175911));
		route.add(new LatLonPoint(38.946290842431665,-77.09675677120686));
		route.add(new LatLonPoint(38.94630857384843,-77.09675677120686));
		route.add(new LatLonPoint(38.94630648779963,-77.0967286080122));
		route.add(new LatLonPoint(38.9463033587263,-77.0966025441885));
		route.add(new LatLonPoint(38.94630492326298,-77.09646306931973));
		route.add(new LatLonPoint(38.94630596628741,-77.09634907543659));
		route.add(new LatLonPoint(38.94630492326298,-77.0962243527174));
		route.add(new LatLonPoint(38.946301794189594,-77.0960707962513));
		route.add(new LatLonPoint(38.94629970814059,-77.0959360152483));
		route.add(new LatLonPoint(38.94629814360381,-77.0957837998867));
		route.add(new LatLonPoint(38.94629397150553,-77.09567651152611));
		route.add(new LatLonPoint(38.946290842431665,-77.09552496671677));
		route.add(new LatLonPoint(38.9462871918453,-77.09536336362362));
		route.add(new LatLonPoint(38.9462871918453,-77.09525741636753));
		route.add(new LatLonPoint(38.94628875638234,-77.09513068199158));
		route.add(new LatLonPoint(38.94628614882058,-77.09496237337589));
		route.add(new LatLonPoint(38.94628562730824,-77.09483899176121));
		route.add(new LatLonPoint(38.94628614882058,-77.09473572671413));
		route.add(new LatLonPoint(38.94628614882058,-77.09458753466606));
		route.add(new LatLonPoint(38.94628771335765,-77.09447152912617));
		route.add(new LatLonPoint(38.94628927789466,-77.09440112113953));
		route.add(new LatLonPoint(38.94628927789466,-77.09434613585472));
		route.add(new LatLonPoint(38.94627624008511,-77.0943434536457));
		route.add(new LatLonPoint(38.94623712664203,-77.09434278309345));
		route.add(new LatLonPoint(38.946171416009065,-77.09434144198895));
		route.add(new LatLonPoint(38.94613230250815,-77.09434144198895));
		route.add(new LatLonPoint(38.94609892563697,-77.0943421125412));
		route.add(new LatLonPoint(38.94606607026406,-77.09434278309345));
		route.add(new LatLonPoint(38.946023827619356,-77.0943421125412));
		route.add(new LatLonPoint(38.9459810634349,-77.09434077143669));
		route.add(new LatLonPoint(38.94591378801931,-77.09434144198895));
		route.add(new LatLonPoint(38.945863722552325,-77.09434144198895));
		route.add(new LatLonPoint(38.94581417856581,-77.09434278309345));
		route.add(new LatLonPoint(38.94571143987293,-77.0943434536457));
		route.add(new LatLonPoint(38.94571091835634,-77.09434479475021));
		route.add(new LatLonPoint(38.94571143987293,-77.09434144198895));
		route.add(new LatLonPoint(38.94565459454229,-77.09434278309345));
		route.add(new LatLonPoint(38.94560244282276,-77.09434077143669));
		route.add(new LatLonPoint(38.94553881767296,-77.09434144198895));
		route.add(new LatLonPoint(38.94551065570315,-77.09434077143669));
		route.add(new LatLonPoint(38.945475713984365,-77.09434077143669));
		route.add(new LatLonPoint(38.945390706447284,-77.09434144198895));
		route.add(new LatLonPoint(38.945334903898214,-77.09433943033218));
		route.add(new LatLonPoint(38.94528014434472,-77.09434144198895));
		route.add(new LatLonPoint(38.94521338978422,-77.0943434536457));
		route.add(new LatLonPoint(38.94514298451561,-77.0943434536457));
		route.add(new LatLonPoint(38.94503711572078,-77.0943421125412));
		route.add(new LatLonPoint(38.94498079137141,-77.0943421125412));
		route.add(new LatLonPoint(38.94495210765779,-77.09434278309345));
	}
	
	/**
	 * Compares two info strings for closeness char by char
	 * @param a compare a
	 * @param b compare b
	 * @return rating of closeness
	 */
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
