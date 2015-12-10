#import <Cordova/CDV.h>

@interface GoogleConvertTrack : CDVPlugin

- (void)reportWithConversionId:(CDVInvokedUrlCommand*)command;

- (void)registerReferrer:(CDVInvokedUrlCommand*)command;

@end
