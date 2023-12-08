import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.immutable._
//import scala.collection.mutable._
import scala.collection.concurrent._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._
import scala.util.control.Breaks.{break, breakable}

object Result10 {

  /*
   * Complete the 'biggerIsGreater' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING w as parameter.
   */

  def biggerIsGreater(w: String): String = {
    // Write your code here
    var i = w.size - 1
    var j = w.size - 1
    var out = ""
    var indexOfBiggerChar = 0
    breakable {
      while (i >= 0) {
        indexOfBiggerChar = w.slice(i, w.size).lastIndexWhere(w(i) < _)
        if (indexOfBiggerChar > 0) {
          out = swap(w, i+indexOfBiggerChar, i)
          break()
        }
        i -= 1
      }
    }

    if (i == -1) {
      "no answer"
    }
    else {
      val strfirstPart = out.slice(0, i + 1)
      val strSecondPart = out.slice(i+1, w.size).sorted
      strfirstPart + strSecondPart
    }
  }

  def swap(str: String, i: Int, j: Int): String = {
    val arr = str.toCharArray
    val temp = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
    arr.mkString("")
  }
}

object Solution10 {
  def main(args: Array[String]) {

    val strings = Seq("zyyyvvvvvuttsrqqokjjheedccb",
      "vvvygfabrsqeitgelpxwodhdfyypoyufxnecmrtkbzbhzfbtvnffcmikqoosfzoozssonomkgmtdqfecrqtps",
      "chntqzcpvrhvzvpywuhxombxcsjlpsergz",
      "bvulomthrfugqfbaknxginokekuemgb",
      "phoatpygffol",
      "gqesmwwfyyuraiwzhdkyvtzprhxzfaocdyxryzpqyewfufkspwvpgyscviersewdcgudhjxnfximarbkgduam",
      "dc",
      "zzzzyyxxxwvvvvusssrrrrqqqqqqqppoonnnnmmmmllllkjiiigfccccbbba",
      "zxwutljib",
      "mzvzrnkxfbznkhmppqwyvmywfmsgmtvxtaxqdmqdryszwmzuvlkvlcpfap",
      "zyyywvvvuttttsssrqponnmllkjjjihgggfffedccbbbaaaa",
      "skmidbvygtsdvujmuckkdbceeffrodszmkfrgugelljlxzribxlhltvxgigxfhotkaxejrvymhrengddobeckxhbgxafm",
      "dkuwfemegcc",
      "nlvhfxgkmsqddkuhfmfjklwcunbnqovmswqlkpjjkuboploggtzdcmjhezsjdvvawlkizfkmfqvrkj",
      "pgnxoizoihrjmybvtyckzsjrxuejyxogxaczxbkndrmboloxaurzpviididhkehp",
      "bdmkhyleclldykvysxkfttkipzdmkexxhmdtdabxjzuxgyvlzyhebe",
      "zzzzxxuutttsrrrqqppnmmkjihhgffddddcbbbaaa",
      "imsyqfpkimjwewbgofakdnblqiamevajfsydpdifzexrprbgaph",
      "zwqnnjhfccba",
      "dtwfgnvmippxcpppjpsyfzhvwnehthaylypapifhbe",
      "xqopdmvkppfbsofyb",
      "hihjflgiyruykigzarpxmhwnpbhfyrhdkcawripafpxhjugcjsgwijzhlauxlutpylcqlsaauveehodlyjowssmui",
      "ufipnealwrfs",
      "mdectlz",
      "zzxwvvvvtssqqqnnniihhhhgggggffeeedddccca",
      "taawnclbnkvbmjyqltuusw",
      "vtjwpnrfyiokoobumdadbylkqtmilwkqkyefvhwsjyrnujet",
      "zwupolhc",
      "dksoddywjmlwlrblpfgmvoriwffjigmllypenwpirsdkmzarmdogjjyyyilfmargfozybd",
      "hcblguwrvptofuusovltoxomaibjwolatgjxwpjuthdyqfpuhtlxfvupwzklqpoqjojzrpfmjppul",
      "pttxpohaxstadlpgmcjafurxabajkhhiffzcxpxvsqmrajaiqxsejtgpbzrpmhhyislimivjjawuxrwzcugeuztlug",
      "tilnsathhuruuknuiwkkrhjmwdtgkcksheondgzaljsssbshydftmnwaplttoqcefbfmirjpfpcofxajoggxkxyfawdetqu",
      "flnheeifaryvjxwflpzzsctzny",
      "ksjjxhgrzxpimodjiilczacynszdurgpydyezuirsmcotqmdbeprkvbifeslngchxsenobejvpdvqeuugltbfzqb",
      "ubtjtgvqzruyybagsdacipuakzuvfnljdarvloeqsadlfwhlhyljxlckxmrklqdwbfroougzwvsfeprcslsggloney",
      "wwejpli",
      "ftscbegsxdpevrxkhryrvee",
      "zzzzzzzyxwwwvvvvvuuuuttttsssrrqppooonnnnnnmmkjjiiiihhhhgggffeeeeeedddbbbba",
      "zzzzyyyxxxxwwvvuuuutsssssrrqppponnnnnkkkkkkkiiihhhhhhggfdddccbbbba",
      "qkjjdrvdvjhvys",
      "zclyjlzazdtqbygplttooaagzanuluifulubgjtjof",
      "oupvmuimmuxpjdktenlghpbxuassvczfbaooostleyftymnfipvpxdeaobpiw",
      "kgifqwfyawkcswjgcxcdwftihbstxuvrhuzkqqlgmiphasblhwzjddafoaa",
      "pocmeneerzqhtfowfilqewraqftnjnlzcxlihjuystugpqscxurmcojjftxaqcjrkritzospygebdjbn",
      "dtejbelxffrwpuyxqgsqeessgryyysgyvolipgqshmkisiza",
      "cbbxbxzvisyo",
      "ylvdhnkazylnhoniwucazmcsxjxbsbdakqcoyimutwqvdpmfstyettunnhjhggeeas",
      "qcmzsuyogfggprrhggpilqbddwuvqxuiulhnjmjavycaefmrthyyyhtncmkdpzqivswxqzfn",
      "umrmwbmrwoq",
      "zzyxwvutsssqppponmmllllkkkkjjihhgffcca",
      "tnnahjkaslbgjphvtcudeppslisjbyriexbrlgqbrymrgvhhefbsynhwvj",
      "yvuttqpnnmlkjiiiheecc",
      "xndmpgqiwrngzqfpslrsyfdptinvkaebazkwiebakwrtwjkpc",
      "bwvuoqrjlwtzxgewzxicttirzlde",
      "tlowqusjopnnkutjazkluatgnexzua",
      "ijtjaaetempfjnvtldkbkxgnaorzrhlbcbudjqeopiuyxsllgaombfzgvmjeydrinklqosxvolknjrprk",
      "fbyryvyzmwanwfsdesteydbztnzcoecclptmvjkpxbiqgwmgsnsrcwdqbswlxdjcsrvpijqpqelxa",
      "hsogummqduoebnhsthxsmiwsrbbvuzlxivgiqyuqwzzubvamuudcsu",
      "cpmuskom",
      "renukixwtdfaevvhyejvtpeiadepkcqq",
      "zyidilgenkmwlssnahsjcibbtktkkrxbmkncqvircgpqwuu",
      "rqamzcuxiwhhrwmizitkrsetonjsicohhsexgjkscwrjcuptaftcpzpqqpzwelgilkiihylkoksbtoajew",
      "crbcjtgzhhdhmiwczyvcpubxltixpqrgucljrqymmbiskvqkczqcyxplaokybqwrhsjaadvtbydjappcnppdwznpdcywvzmy",
      "dwqqfcbmmjtnozmeyfswxxbsrqjytnuvjtlkk",
      "qehjbqgdldwujafufxlugvafxxajcegeweahpdvcvzcllhmydithuhvnursvpuxuxbxvatugmpqexjzbsng",
      "xtubqmlvhvdgp",
      "stsktwhdtxii",
      "nzcobtvjtmsuonkqgytwkfdhpaopc",
      "ivdvxowitlyegsgcbucxvbtaamjlkvghufjpnlqrfifjbzljbztrizdfoh",
      "jkxxsspbkxzegvavbdvrpqiku",
      "uzbpcvrzttpmsykzpcrjrtufnpwfmmsnhedoipemhntppgjpgzqhbtgakwfsuuyqgfpm",
      "octjqnyrjfqffgshvaegzgxagrgoduscszmjtpjbacoerhcnaeqxfzsdpy",
      "aomobiugdtujoolxxnzaqbppaxflvmpoqucxzomoafbbkswngudjpcewmtxaulfrbrhtsakcgabsrlggdtfhczqxgzuzkmax",
      "mcysjyqkqtupiglvbgcpcvyztimdvezg",
      "lpgqoniffxzhkkbkjkptuacprbqxzfjxyzbxoeidfyyhjcotkryrvaxweiewuiefwinhdyslcwtrqkccwxcjdprkovbznpkomhv",
      "tvuassvlpyeccgkfxjsadiigugmxyfoaysfmayiifybeylmjkqpicxpubcxxpowhqrxippnn",
      "zzzzyyyyyyyyyxxwwwwwwwvvuuuuuutsssssssrrqqqqqppppooonnnnmmmmmmllkjiiiiihggggffffffeeeeedddddbbbbbaaa",
      "zzyyyywtrqqpoonnnmmlkiiihhgfeeedcccbbbaaaa",
      "bxclnmicohjaenbraguyobyjntxxrxivqlonxqtvmnfcxwgjkodhngowfur",
      "zzzzyyxxxwwvvuuttttrqqqqqqqqpooonnnnmlllljjjjjiiihhhgggggffeeeeeeeedddccccccccbbbbbaaa",
      "gurgskojvnxvorsrggiitebpwgouyc",
      "mwwtxwxyarksqmvwzhufcqzrsutjkmjgckrarwjobrmlzpdvqoovhciardkvurhkufe",
      "fnvillxsc",
      "cqwbbenzrquuwgphkfvzmohtuyokwgthicsjuawny",
      "pr",
      "zyyxxwuutrqonlligggfeea",
      "zzzzzyyyywwwwvvvvvvuutttttssssrqqqonnnnmmmlkkkkkjjiihhhhhggfffeeeeeeddddcbbbbbaa")

    //strings.foreach(s => println(Result10.biggerIsGreater(s)))

    println(Result10.biggerIsGreater("wwejpli"))

    "wwelijp"
  }
}
