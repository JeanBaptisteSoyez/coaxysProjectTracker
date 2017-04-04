using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace CoaxysProjectTracker.Extensions
{
    public enum TempDataMessageType { Success, Info, Warning, Danger }

    public static class TempDataExtensions
    {
        public static void AddMessage(this TempDataDictionary tempData, int type, string message)
        {
            if (tempData["messages"] == null)
                tempData["messages"] = new Dictionary<int, List<string>>()
                {
                    { (int)TempDataMessageType.Success, new List<string>() },
                    { (int)TempDataMessageType.Info, new List<string>() },
                    { (int)TempDataMessageType.Warning, new List<string>() },
                    { (int)TempDataMessageType.Danger, new List<string>() }
                };

            (tempData["messages"] as Dictionary<int, List<string>>)[type].Add(message);
        }

        public static string GetMessages(this TempDataDictionary tempData)
        {
            string str = "";

            if(!(tempData["messages"] is Dictionary<int, List<string>>))
            {
                return str;
            }

            string template = @"
                <div class=""alert alert-{0} alert-dismissible"" role=""alert"">
                    <button type=""button"" class=""close"" data-dismiss=""alert"" aria-label=""Close"">
                        <span aria-hidden=""true"">&times;</span>
                    </button>
                    {1}
                </div>";
            
            foreach (KeyValuePair<int, List<string>> item in (tempData["messages"] as Dictionary<int, List<string>>))
            {
                string enumValue = Enum.GetName(typeof(TempDataMessageType), item.Key).ToLower();
                foreach (string message in (tempData["messages"] as Dictionary<int, List<string>>)[item.Key])
                {
                    str += String.Format(template, enumValue, message);
                }
            }

            return str;
        }
    }
}