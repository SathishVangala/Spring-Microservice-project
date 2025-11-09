def filePath = '''ComponentID  ComponentName  Frequency  ErrorDetail  ServicenowGroup  ServicenowDescription  Urgency   Impact  Threshold  InterfaceID  IntegrationName  MasterFlowID  ChildFlowID   StausReportURL

APPSVC084167

ERP FIN GL Integration_Comp

no files found

Daily

T2R, Humana PCO IFM to Oracle AHCS, PROD

SRE_Oracle_FAPNR

NA

HUM2INT282

Humana PCO IFM to Oracle AHCS

uacP-EJHEfChdMdr_SPNDW

uacP-EJHEfChdMdr_SPNDw

https://fa-eult-saasfaprod1.fa.ocs.oraclecloud.com/cs/idcplg?IdcService=GET_FILE&dID=13252388


'''
// Clean and parse
def lines = filePath.readLines().findAll { it.trim() }

// Remove header
def values = lines[1..-1].collect { it == '""' ? "" : it.trim() }

// Ensure exactly 14 fields
if (values.size() < 14) {
  println "⚠️ Not enough fields (${values.size()}) - padding with blanks."
  while (values.size() < 14) {
    values << ""
  }
} else if (values.size() > 14) {
  println "⚠️ Too many fields (${values.size()}) - trimming extra."
  values = values[0..13]
}

// Extract desired fields
def outputMap = [
        ComponentID     : values[0],
        ComponentName   : values[1],
        ErrorDetail     : values[3],
        ServicenowDesc  : values[5],
        InterfaceID     : values[9],
        IntegrationName : values[10],
        MasterFlowID    : values[11],
        ChildFlowID     : values[12],
        StausReportURL  : values[13]
]

// Print nicely
println "\n→ Output:"
outputMap.each { key, val ->
  println "${key.padRight(20)}: ${val}"
}