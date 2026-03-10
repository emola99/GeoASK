package com.example.geoankieta

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolygonOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap
        mMap.setMinZoomPreference(10.0f)
        mMap.setMaxZoomPreference(20.0f)
        val zoomLevel = 18.0f
        val campus = LatLng(52.221188, 21.008081)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(campus,zoomLevel ))

        val polygonGlowny = PolygonOptions()
            .add(LatLng(52.2213700402298, 21.01005432929957))
            .add(LatLng(52.22069086284824, 21.01106518790579))
            .add(LatLng(52.22014970404271, 21.010681297824306))
            .add(LatLng(52.22017599522516, 21.009147074267787))
            .add(LatLng(52.22087489855589, 21.009160819505215))
            .add(LatLng(52.2213700402298, 21.01005432929957))
            .fillColor(Color.argb(128,173,216,230))
            .strokeColor(Color.GRAY)
            .clickable(true)
        val gmachGlowny = googleMap.addPolygon(polygonGlowny)

        val polygonSzczeki = PolygonOptions()
            .add(LatLng(52.22014970404271, 21.010686662242335))
            .add(LatLng(52.220080689614754, 21.01178636793844))
            .add(LatLng(52.22017599522516, 21.01184001211874))
            .add(LatLng(52.22069524288912, 21.01106217150442))
            .add(LatLng(52.22014970404271, 21.010686662242335))
            .fillColor(Color.argb(128,173,216,230))
            .strokeColor(Color.GRAY)
            .clickable(true)
        val szczeki = googleMap.addPolygon(polygonSzczeki)


        val polygonFontanna = PolygonOptions()
            .add(LatLng(52.221716985720306, 21.00793085766308))
            .add(LatLng(52.221375210994104, 21.00776724291317))
            .add(LatLng(52.22117145942516, 21.007611674790308))
            .add(LatLng(52.22109258759905, 21.007370275978968))
            .add(LatLng(52.22096770692132, 21.007354182724878))
            .add(LatLng(52.220915125478264, 21.008384150986597))
            .add(LatLng(52.220905266450764, 21.00882403326504))
            .add(LatLng(52.22087240300996, 21.00915394497387))
            .add(LatLng(52.22129798268686, 21.008541060213968))
            .add(LatLng(52.221716985720306, 21.00793085766308))
            .fillColor(Color.argb(128,173,216,230))
            .strokeColor(Color.GRAY)
            .clickable(true)
        val fontanna = googleMap.addPolygon(polygonFontanna)

        val polygonMechanika = PolygonOptions()
            .add(LatLng(52.220964102139696, 21.007343439691496))
            .add(LatLng(52.220214810637835, 21.007265655630064))
            .add(LatLng(52.22017208749583, 21.00914856635852))
            .add(LatLng(52.22087537091119, 21.00915393077655))
            .add(LatLng(52.22088769470355, 21.008983610504103))
            .add(LatLng(52.220900018492436, 21.008824019067717))
            .add(LatLng(52.220910699106724, 21.008604077928496))
            .add(LatLng(52.2209131638635, 21.00838681899829))
            .add(LatLng(52.22095259995338, 21.00765189372821))
            .add(LatLng(52.220964102139696, 21.007343439691496))
            .fillColor(Color.argb(128,173,216,230))
            .strokeColor(Color.GRAY)
            .clickable(true)
        val mechanika = googleMap.addPolygon(polygonMechanika)



        val polygonChemia = PolygonOptions()
            .add(LatLng(52.222239501611114, 21.00884549093716))
            .add(LatLng(52.22136535206874, 21.01005784941189))
            .add(LatLng(52.22111230556872, 21.009601873879358))
            .add(LatLng(52.220872403009935, 21.009188813691065))
            .add(LatLng(52.22172027200293, 21.007933539872095))
            .add(LatLng(52.222239501611114, 21.00884549093716))
            .fillColor(Color.argb(128,173,216,230))
            .strokeColor(Color.GRAY)
            .clickable(true)

        val chemia = googleMap.addPolygon(polygonChemia)

        val polygonFizyka = PolygonOptions()
            .add(LatLng(52.221092063758675, 21.00737132887142))
            .add(LatLng(52.221310604102314, 21.00675173858898))
            .add(LatLng(52.22139604815475, 21.006456695597343))
            .add(LatLng(52.221586653525485, 21.006612263720207))
            .add(LatLng(52.221967861812665, 21.006601534884147))
            .add(LatLng(52.221987579393684, 21.00730427364605))
            .add(LatLng(52.22195471675377, 21.00754030803936))
            .add(LatLng(52.221717283457984, 21.00793325166004))
            .add(LatLng(52.22154721799867, 21.007848762076073))
            .add(LatLng(52.22137550873408, 21.007769636910133))
            .add(LatLng(52.22117011400487, 21.007612727682762))
            .add(LatLng(52.221092063758675, 21.00737132887142))
            .fillColor(Color.argb(128,173,216,230))
            .strokeColor(Color.GRAY)
            .clickable(true)

        val fizyka = googleMap.addPolygon(polygonFizyka)

        val polygonTransport = PolygonOptions()
            .add(LatLng(52.22172030960198, 21.007931600911224))
            .add(LatLng(52.22198156829636, 21.008387576443756))
            .add(LatLng(52.222242825453705, 21.008843551976288))
            .add(LatLng(52.22240056488003, 21.008781861168945))
            .add(LatLng(52.22242425055733, 21.00864244840525))
            .add(LatLng(52.222702618216374, 21.00821335706791))
            .add(LatLng(52.22276749896393, 21.00812913782633))
            .add(LatLng(52.22280200410365, 21.00752027637995))
            .add(LatLng(52.22259114495215, 21.007467231516248))
            .add(LatLng(52.22241697505079, 21.007384083036786))
            .add(LatLng(52.22228831944728, 21.007347980675284))
            .add(LatLng(52.22222259458825, 21.007342616257255))
            .add(LatLng(52.222114148358216, 21.00737212055642))
            .add(LatLng(52.22202541942758, 21.007404307064597))
            .add(LatLng(52.221971196104924, 21.007421741423194))
            .add(LatLng(52.22195584304869, 21.00754189016423))
            .add(LatLng(52.22172030960198, 21.007931600911224))
            .fillColor(Color.argb(128,173,216,230))
            .strokeColor(Color.GRAY)
            .clickable(true)

        val transport = googleMap.addPolygon(polygonTransport)

        val polygonMINI = PolygonOptions()
            .add(LatLng(52.22284997391328, 21.00649724068547))
            .add(LatLng(52.2228031455535, 21.00752050342465))
            .add(LatLng(52.22269511151753, 21.007494351886756))
            .add(LatLng(52.222591184991515, 21.007466859244353))
            .add(LatLng(52.22241701509036, 21.0073850518694))
            .add(LatLng(52.22228803033651, 21.00734750094319))
            .add(LatLng(52.222222305477096, 21.007343477629668))
            .add(LatLng(52.222113859246384, 21.007371640824324))
            .add(LatLng(52.22202513031516, 21.007403827332503))
            .add(LatLng(52.22197090699208, 21.0074212616911))
            .add(LatLng(52.22198815987479, 21.007304585598952))
            .add(LatLng(52.22197008542612, 21.006599164628035))
            .add(LatLng(52.22284997391328, 21.00649724068547))
            .fillColor(Color.argb(128,173,216,230))
            .strokeColor(Color.GRAY)
            .clickable(true)

        val mini = googleMap.addPolygon(polygonMINI)

        val polygonTechnologiaChem = PolygonOptions()
            .add(LatLng(52.22295572110311, 21.004996638513788))
            .add(LatLng(52.22285056286254, 21.006498675562128))
            .add(LatLng(52.22196985282099, 21.00659791729568))
            .add(LatLng(52.22194191956749, 21.005012731767877))
            .add(LatLng(52.22295572110311, 21.004996638513788))
            .fillColor(Color.argb(128,173,216,230))
            .strokeColor(Color.GRAY)
            .clickable(true)

        val technologiaChem = googleMap.addPolygon(polygonTechnologiaChem)

        val polygonMuzeum = PolygonOptions()
            .add(LatLng(52.221396355804515, 21.006456614695658))
            .add(LatLng(52.22130926859623, 21.006751657687296))
            .add(LatLng(52.22109237141058, 21.007371247969736))
            .add(LatLng(52.22096469588634, 21.007343394300285))
            .add(LatLng(52.2202149821334, 21.007266409406267))
            .add(LatLng(52.22022282424359, 21.00624119716964))
            .add(LatLng(52.221006622144955, 21.00627338367782))
            .add(LatLng(52.221396355804515, 21.006456614695658))
            .fillColor(Color.argb(128,173,216,230))
            .strokeColor(Color.GRAY)
            .clickable(true)

        val muzeum = googleMap.addPolygon(polygonMuzeum)

        val polygonElektryczny = PolygonOptions()
            .add(LatLng(52.221969193467935, 21.006599424319464))
            .add(LatLng(52.22158634204598, 21.006610153155524))
            .add(LatLng(52.22139573667397, 21.006457267241675))
            .add(LatLng(52.22100522418493, 21.00627131053772))
            .add(LatLng(52.2210208342757, 21.00585690924492))
            .add(LatLng(52.22106930768036, 21.005469330042267))
            .add(LatLng(52.22119090175079, 21.005439825743103))
            .add(LatLng(52.22128949129323, 21.005458601206207))
            .add(LatLng(52.221365618182894, 21.005771520697408))
            .add(LatLng(52.22147420167104, 21.005818905166514))
            .add(LatLng(52.221957420684575, 21.005812645455364))
            .add(LatLng(52.221969193467935, 21.006599424319464))
            .fillColor(Color.argb(128,173,216,230))
            .strokeColor(Color.GRAY)
            .clickable(true)

        val elektryczny = googleMap.addPolygon(polygonElektryczny)

        val polygonLotniczy = PolygonOptions()
            .add(LatLng(52.22193960947926, 21.005011423209854))
            .add(LatLng(52.221956040807825, 21.005813403705307))
            .add(LatLng(52.22147336643283, 21.005818898401888))
            .add(LatLng(52.22136491837311, 21.00577061863962))
            .add(LatLng(52.2212909763624, 21.005458141289385))
            .add(LatLng(52.22118992208197, 21.00543936582628))
            .add(LatLng(52.22106914959155, 21.005468870125444))
            .add(LatLng(52.2210201293517, 21.005858413963708))
            .add(LatLng(52.221005340844606, 21.006271474152))
            .add(LatLng(52.220225651151786, 21.006240360371052))
            .add(LatLng(52.22024372631048, 21.005100421539723))
            .add(LatLng(52.22193960947926, 21.005011423209854))
            .fillColor(Color.argb(128,173,216,230))
            .strokeColor(Color.GRAY)
            .clickable(true)

        val lotniczy = googleMap.addPolygon(polygonLotniczy)


        val questionDialog = QuestionDialog(this)

        googleMap.setOnPolygonClickListener { clickedPolygon ->
            if (clickedPolygon == gmachGlowny) {
                gmachGlowny.fillColor = Color.argb(128, 255, 0, 0)
                questionDialog.showSurveyDialog("Gmach Główny")
            } else {
                gmachGlowny.fillColor = Color.argb(128,173,216,230)
            }
            if (clickedPolygon == chemia) {
                chemia.fillColor = Color.argb(128, 255, 0, 0)
                questionDialog.showSurveyDialog("Wydział Chemii")
            } else {
                chemia.fillColor = Color.argb(128,173,216,230)
            }

            if (clickedPolygon == fontanna) {
                fontanna.fillColor = Color.argb(128, 255, 0, 0)
                questionDialog.showSurveyDialog("Skwer przy fontannie")
            } else {
                fontanna.fillColor = Color.argb(128,173,216,230)
            }
            if (clickedPolygon == szczeki) {
                szczeki.fillColor = Color.argb(128, 255, 0, 0)
                questionDialog.showSurveyDialog("Szczęki Rektora")
            } else {
                szczeki.fillColor = Color.argb(128,173,216,230)
            }

            if (clickedPolygon == mechanika) {
                mechanika.fillColor = Color.argb(128, 255, 0, 0)
                questionDialog.showSurveyDialog("Gmach Mechaniki")
            } else {
                mechanika.fillColor = Color.argb(128,173,216,230)
            }

            if (clickedPolygon == fizyka) {
                fizyka.fillColor = Color.argb(128, 255, 0, 0)
                questionDialog.showSurveyDialog("Wydział Fizyki")
            } else {
                fizyka.fillColor = Color.argb(128,173,216,230)
            }

            if (clickedPolygon == transport) {
                transport.fillColor = Color.argb(128, 255, 0, 0)
                questionDialog.showSurveyDialog("Wydział Transportu")
            } else {
                transport.fillColor = Color.argb(128,173,216,230)
            }

            if (clickedPolygon == mini) {
                mini.fillColor = Color.argb(128, 255, 0, 0)
                questionDialog.showSurveyDialog("Wydział MiNi")
            } else {
                mini.fillColor = Color.argb(128,173,216,230)
            }

            if (clickedPolygon == technologiaChem) {
                technologiaChem.fillColor = Color.argb(128, 255, 0, 0)
                questionDialog.showSurveyDialog("Wydział Technologii Chemicznej")
            } else {
                technologiaChem.fillColor = Color.argb(128,173,216,230)
            }

            if (clickedPolygon == muzeum) {
                muzeum.fillColor = Color.argb(128, 255, 0, 0)
                questionDialog.showSurveyDialog("Muzeum Politechniki Warszawskiej")
            } else {
                muzeum.fillColor = Color.argb(128,173,216,230)
            }

            if (clickedPolygon == elektryczny) {
                elektryczny.fillColor = Color.argb(128, 255, 0, 0)
                questionDialog.showSurveyDialog("Wydział Elektryczny")
            } else {
                elektryczny.fillColor = Color.argb(128,173,216,230)
            }

            if (clickedPolygon == lotniczy) {
                lotniczy.fillColor = Color.argb(128, 255, 0, 0)
                questionDialog.showSurveyDialog("Wydział Mechaniczny Energetyki i Lotnictwa")
            } else {
                lotniczy.fillColor = Color.argb(128,173,216,230)
            }
        }
    }
}


