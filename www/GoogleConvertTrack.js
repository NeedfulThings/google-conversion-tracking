var argscheck = require('cordova/argscheck'),
    exec = require('cordova/exec');

function GoogleConvertTrack() {
  
}

GoogleConvertTrack.prototype.reportWithConversionId = function (conversionId, label, value, repeatable, success, fail) {
  argscheck.checkArgs('sSS*FF', 'GoogleConvertTrack.reportWithConversionId', arguments);
  exec(success, fail, 'GoogleConvertTrack', 'reportWithConversionId', [conversionId, label, value, repeatable]);
}

GoogleConvertTrack.prototype.registerReferrer = function (success, fail) {
  argscheck.checkArgs('fF', 'GoogleConvertTrack.registerReferrer', arguments);
  exec(success, fail, 'GoogleConvertTrack', 'registerReferrer', []);
}

module.exports = new GoogleConvertTrack();