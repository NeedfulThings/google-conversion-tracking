#import "ACTReporter.h"
#import "GoogleConvertTrack.h"
#import <Cordova/CDV.h>

@implementation GoogleConvertTrack

- (void)reportWithConversionId:(CDVInvokedUrlCommand*)command
{
    NSString *conversion_id = [command.arguments objectAtIndex:0];
    NSString *tracking_label = [command.arguments objectAtIndex:1];
    NSString *tracking_value = [command.arguments objectAtIndex:2];
    BOOL repeatable = [[command.arguments objectAtIndex:3] boolValue];

    [self.commandDelegate runInBackground:^{
      [ACTConversionReporter reportWithConversionID:conversion_id label:tracking_label value:tracking_value isRepeatable:repeatable];

      CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:tracking_label];
      [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    }];
}

- (void)registerReferrer:(CDVInvokedUrlCommand*)command
{
    // Not implementation
}

@end

