using CoaxysProjectTracker.Api.Extensions;
using CoaxysProjectTracker.Entities;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Net.Http;
using System.Threading.Tasks;

namespace CoaxysProjectTracker.Api
{
    public class API
    {
        // Get API conf from main project's Web.config
        private static readonly string baseUrl = ConfigurationManager.AppSettings.Get("api:BaseUrl");

        // Create a single instance of client for all requests
        private static readonly HttpClient httpClient = new HttpClient();

        public static async Task<T> GetAsync<T>(string service)
        {
            string uri = baseUrl + service;
            
            try
            {
                var response = await httpClient.GetStringAsync(uri);
                return JsonConvert.DeserializeObject<T>(response);
            }
            catch (Exception)
            {
                return default(T);
            }
        }

        public static async Task<T> PostAsync<T>(string service, object data)
        {
            string uri = baseUrl + service;
            IDictionary<string, string> dictionary = data.AsStrStrDictionary();
            
            try
            {
                var content = new FormUrlEncodedContent(dictionary);
                var response = await httpClient.PostAsync(uri, content);
                var responseContent = await response.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<T>(responseContent);
            }
            catch (Exception)
            {
                return default(T);
            }
        }

        public static async Task<T> PutAsync<T>(string service, object data)
        {
            string uri = baseUrl + service;
            IDictionary<string, string> dictionary = data.AsStrStrDictionary();

            try
            {
                var content = new FormUrlEncodedContent(dictionary);
                var response = await httpClient.PutAsync(uri, content);
                var responseContent = await response.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<T>(responseContent);
            }
            catch (Exception)
            {
                return default(T);
            }
        }

        public static async Task<T> DeleteAsync<T>(string service, object data)
        {
            string uri = baseUrl + service;
            IDictionary<string, string> dictionary = data.AsStrStrDictionary();

            try
            {
                var content = new FormUrlEncodedContent(dictionary);
                var response = await httpClient.DeleteAsync(uri);
                var responseContent = await response.Content.ReadAsStringAsync();
                return JsonConvert.DeserializeObject<T>(responseContent);
            }
            catch (Exception)
            {
                return default(T);
            }
        }
    }
}
