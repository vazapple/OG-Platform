/*
 * @copyright 2012 - present by OpenGamma Inc
 * @license See distribution for license
 */
$.register_module({
    name: 'og.views.gadget',
    dependencies: ['og.common', 'og.api'],
    obj: function () {
        var module = this, view, common = og.common, routes = common.routes;
        return view = {
            init: function () {for (var rule in view.rules) routes.add(view.rules[rule]);},
            timeseries: function (args) {
                var options = {selector: '.OG-timeseries-gadget', datapoints_link: false};
                $('#gadget_content').html('<section class="' + options.selector.substring(1) + '"></section>');
                if (args.id)
                    options.id = args.id;
                else
                    options.data = og.api.common.get_cache(args.key) || {};
                common.gadgets.timeseries(options);
            },
            rules: {
                timeseries: {route: '/timeseries/id:?/key:?', method: module.name + '.timeseries'}
            }
        }
    }
});
