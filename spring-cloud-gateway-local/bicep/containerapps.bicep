resource logAnalyticsWorkspace 'Microsoft.OperationalInsights/workspaces@2020-03-01-preview' = {
  name: 'some-log-anayltics'
  location: 'eastus'
  properties: any({
    retentionInDays: 30
    features: {
      searchVersion: 1
    }
    sku: {
      name: 'PerGB2018'
    }
  })
}

resource environment 'Microsoft.App/managedEnvironments@2024-10-02-preview' = {
  location: 'eastus'
  name: 'some-aca-env'
  properties: {
    appLogsConfiguration: {
      destination: 'log-analytics'
      logAnalyticsConfiguration: {
        customerId: logAnalyticsWorkspace.properties.customerId
        sharedKey: logAnalyticsWorkspace.listKeys().primarySharedKey
      }
    }
    workloadProfiles: [
      {
        workloadProfileType: 'Consumption'
        name: 'Consumption'
      }
    ]
  }
}

resource symbolicname 'Microsoft.App/managedEnvironments/javaComponents@2024-10-02-preview' = {
  parent: environment
  name: 'scggateway'
  properties: {
    componentType: 'SpringCloudGateway'
    ingress: {}
    serviceBinds: [
      { 
        name: 'eureka'
        serviceId: '${environment.id}/javaComponents/eureka'   
      }
      { 
        name: 'eurekasecondary'
        serviceId: '${environment.id}/javaComponents/eurekasecondary'   
      }
      { 
        name: 'admin'
        serviceId: '${environment.id}/javaComponents/admin'   
      }
    ]
    springCloudGatewayRoutes: [
      {
        filters: [
          'SetPath=/'
        ]
        id: 'gogle'
        predicates: [
          'Path=/redirect/google'
        ]
        uri: 'https://google.com'
      }
      {
        filters: [
          'RewritePath=/v2/(?<segment>.*),/$\\{segment}'
        ]
        id: 'containerapps'
        predicates: [
          'Path=/v2/**'
        ]
        uri: 'https://someapp.funnyname-1234abc.eastus.azurecontainerapps.io'
      }
    ]
  }
}
