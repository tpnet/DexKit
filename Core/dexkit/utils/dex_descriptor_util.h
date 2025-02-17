#pragma once

#include <string>
#include <string_view>

namespace dexkit {

inline bool IsPrimitiveName(std::string_view type_name) {
    return type_name == "boolean" || type_name == "byte" || type_name == "char" || type_name == "short"
           || type_name == "int" || type_name == "long" || type_name == "float" || type_name == "double"
           || type_name == "void";
}

inline bool IsPrimitiveType(std::string_view descriptor) {
    return descriptor == "Z" || descriptor == "B" || descriptor == "C" || descriptor == "S"
           || descriptor == "I" || descriptor == "J" || descriptor == "F" || descriptor == "D"
           || descriptor == "V";
}

static std::string GetPrimitiveType(std::string_view type_name) {
    if (type_name == "boolean") return "Z";
    if (type_name == "byte") return "B";
    if (type_name == "char") return "C";
    if (type_name == "short") return "S";
    if (type_name == "int") return "I";
    if (type_name == "long") return "J";
    if (type_name == "float") return "F";
    if (type_name == "double") return "D";
    if (type_name == "void") return "V";
    abort();
}

static std::string GetPrimitiveName(std::string_view descriptor) {
    if (descriptor == "Z") return "boolean";
    if (descriptor == "B") return "byte";
    if (descriptor == "C") return "char";
    if (descriptor == "S") return "short";
    if (descriptor == "I") return "int";
    if (descriptor == "J") return "long";
    if (descriptor == "F") return "float";
    if (descriptor == "D") return "double";
    if (descriptor == "V") return "void";
    abort();
}

// NOLINTNEXTLINE
static std::string DescriptorToName(std::string_view descriptor) {
    if (descriptor.starts_with('[')) {
        return DescriptorToName(descriptor.substr(1)) + "[]";
    }
    if (descriptor.size() == 1) {
        return GetPrimitiveName(descriptor);
    }
    std::string result(descriptor.substr(1, descriptor.size() - 2));
    std::replace(result.begin(), result.end(), '/', '.');
    return result;
}

// NOLINTNEXTLINE
static std::string NameToDescriptor(std::string_view type_name, bool type_start = true, bool type_end = true) {
    if (type_name.ends_with("[]")) {
        return "[" + NameToDescriptor(type_name.substr(0, type_name.size() - 2));
    }
    if (IsPrimitiveName(type_name)) {
        return GetPrimitiveType(type_name);
    }
    std::string result(type_name);
    std::replace(result.begin(), result.end(), '.', '/');
    return (type_start ? "L" : "") + result + (type_end ? ";" : "");
}

}
