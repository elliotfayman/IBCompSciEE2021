# IB Comp Sci EE2021

## Abstract

This essay will investigate the methods by which viruses attempt to avoid static, signature-based
detection. That is, detection that is based on the analysis of a single stagnant source of
information. Specifically, this paper will analyze the common techniques that metamorphic
viruses use to avoid detection and a determination on which of these techniques are most
effective at avoiding detection will be made.

---

## Virus Detecter 

This foulder contains resources used to detect viruses. Utilizing java, these methods where implimented in sensible way as to be able to utilize the 
same methodology without the need to anylize a real virus. The different scanning methods are listed below:
- [Direct Compare:](https://github.com/elliotfayman/IBCompSciEE2021/blob/main/VirusDetectors/DirectCompare.java) Directly Compares to files to check for exact simularity.
- [eometric Detection:](https://github.com/elliotfayman/IBCompSciEE2021/blob/main/VirusDetectors/GeometricDetection.java) Compares the size of two files for size simularity.
- [Head Footer:](https://github.com/elliotfayman/IBCompSciEE2021/blob/main/VirusDetectors/HeadFooter.java) Compares just the begining or end of a file for simularity. 
- [Signiture Match:](https://github.com/elliotfayman/IBCompSciEE2021/blob/main/VirusDetectors/SignatureMatch.java) First removes common text and punctuation from both files being compared and then compares the core elements of the file for simularity.
- [Smart Scan:](https://github.com/elliotfayman/IBCompSciEE2021/blob/main/VirusDetectors/SmartScan.java) First removes the most common words and then compares the combined frequency of each text in each file and removes the least frequent words before comparing.
- [Static Decription:](https://github.com/elliotfayman/IBCompSciEE2021/blob/main/VirusDetectors/StaticDecription.java) Rather than comparing the text to one another, treat the text as symbols and determine the amount of occurences of each symbol in each text. Then compare the amount of occurences of each text to one another and count the amount of matching comparisons.
- [Subsequence Compare:](https://github.com/elliotfayman/IBCompSciEE2021/blob/main/VirusDetectors/SubSequenceCompare.java) Break up each file into partails and compare each word within the partail to another partail in the different file ignoring order the word is found. 

## Virus Generators
This foulder creates simulated viruses. To ensure the saftey of the technology used while conducting this research, live dangourus malware will not be used. Rather, large text files will be used as anologues to a virus. A smaller subtext will then be inserted into several large texts and this smaller text will be treated as the dangourus malware. Here are the different methods by which the virus-text is inserted:
- [ECHS:](https://github.com/elliotfayman/IBCompSciEE2021/blob/main/VirusGenerators/ECHF.java) Virus text is inserted at the head and footer of the text file.
- [ECRL:](https://github.com/elliotfayman/IBCompSciEE2021/blob/main/VirusGenerators/ECRL.java) Virus text is inserted at a random location in the text file.
- [ECV:](https://github.com/elliotfayman/IBCompSciEE2021/blob/main/VirusGenerators/EncryptVirusConstant.java) Virus is first encrypted by creating a hash key of virus-text keys and random letter value pairs. This hash is used to translate the virus into a unique looking text that can then be inserted.
- [GCI:](https://github.com/elliotfayman/IBCompSciEE2021/blob/main/VirusGenerators/GCI.java) Virus is augmented by placing a random amount of do-nothing text between each real virus text.
- [NECRL:](https://github.com/elliotfayman/IBCompSciEE2021/blob/main/VirusGenerators/NECRL.java) Virus is placed in a random location but this location does not change between virus generations.
- [PS:](https://github.com/elliotfayman/IBCompSciEE2021/blob/main/VirusGenerators/PermuationSwap.java) Virus text is swapped around to create a newer looking string.
